package learn.spring.categoryapi.api.v1.mapper;

import learn.spring.categoryapi.api.v1.model.CustomerDTO;
import learn.spring.categoryapi.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void shouldReturnCustomerDTOWithEqualPropertyValue() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ivan");
        customer.setLastName("Wang");

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(customer.getId(), customerDTO.getId());
        assertEquals(customer.getFirstName(), customerDTO.getFirstname());
        assertEquals(customer.getLastName(), customerDTO.getLastname());
    }

}