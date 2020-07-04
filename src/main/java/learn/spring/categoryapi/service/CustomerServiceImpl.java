package learn.spring.categoryapi.service;

import learn.spring.categoryapi.api.v1.mapper.CustomerMapper;
import learn.spring.categoryapi.api.v1.model.CustomerDTO;
import learn.spring.categoryapi.model.Customer;
import learn.spring.categoryapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Value("${customer.rest.root.url}")
    private String customerUrl;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl(customerUrl+customer.getId());
                    return customerDTO;
                })
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

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).orElseThrow());
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer returnedCustomer = customerRepository.save(customer);
        CustomerDTO returnedCustomerDTO = customerMapper.customerToCustomerDTO(returnedCustomer);
        returnedCustomerDTO.setCustomerUrl("/api/v1/customers/"+returnedCustomer.getId());
        return returnedCustomerDTO;
    }
}
