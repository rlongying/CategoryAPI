package learn.spring.categoryapi.controller.v1;

import learn.spring.categoryapi.api.v1.model.CustomerDTO;
import learn.spring.categoryapi.repository.CustomerRepository;
import learn.spring.categoryapi.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    public static final String FIRSTNAME = "Ivan";
    public static final String LASTNAME = "Wang";
    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void shouldReturnCustomerListJsonWhenRequestCustomers() throws Exception {
        List<CustomerDTO> customers = Arrays.asList(new CustomerDTO(), new CustomerDTO());

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/v1/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",  hasSize(2)));
    }

    @Test
    void shouldReturnIvanWhenRequestCustomerFirstNameIvan() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRSTNAME);
        customerDTO.setLastname(LASTNAME);

        when(customerService.getCustomerByFirstName(anyString())).thenReturn(customerDTO);

        mockMvc.perform(get("/api/v1/customers/" + FIRSTNAME).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstname", equalTo(FIRSTNAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LASTNAME)));
    }
}