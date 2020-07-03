package learn.spring.categoryapi.service;

import learn.spring.categoryapi.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByLastName(String lastName);

    CustomerDTO getCustomerByFirstName(String firstName);
}
