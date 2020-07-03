package learn.spring.categoryapi.repository;

import learn.spring.categoryapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByLastName(String lastName);

    Customer findCustomerByFirstName(String firstName);
}
