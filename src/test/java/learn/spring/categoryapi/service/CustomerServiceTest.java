package learn.spring.categoryapi.service;

import learn.spring.categoryapi.api.v1.mapper.CustomerMapper;
import learn.spring.categoryapi.api.v1.model.CustomerDTO;
import learn.spring.categoryapi.model.Customer;
import learn.spring.categoryapi.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Wang";
    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
       MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void shouldReturnCustomerListWhenGetAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());
        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        assertEquals(customers.size(), customerDTOS.size());
    }

    @Test
    public void shouldReturnACustomerWhenGetCustomerByFirstName() {
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findCustomerByFirstName(anyString())).thenReturn(customer);

        CustomerDTO customerDTO = customerService.getCustomerByFirstName(FIRST_NAME);
        assertEquals(customer.getFirstName(), customerDTO.getFirstname());

    }

    @Test
    public void shouldReturnACustomerWhenGetCustomerByLastName() {
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findCustomerByLastName(anyString())).thenReturn(customer);

        CustomerDTO customerDTO = customerService.getCustomerByLastName(LAST_NAME);
        assertEquals(customer.getLastName(), customerDTO.getLastname());

    }
}