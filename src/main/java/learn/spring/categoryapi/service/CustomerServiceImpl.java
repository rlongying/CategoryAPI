package learn.spring.categoryapi.service;

import learn.spring.categoryapi.api.v1.mapper.CustomerMapper;
import learn.spring.categoryapi.api.v1.model.CustomerDTO;
import learn.spring.categoryapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByLastName(String lastName) {
        return customerMapper.customerToCustomerDTO(customerRepository.findCustomerByLastName(lastName));
    }

    @Override
    public CustomerDTO getCustomerByFirstName(String firstName) {
        return customerMapper.customerToCustomerDTO(customerRepository.findCustomerByFirstName(firstName));
    }
}
