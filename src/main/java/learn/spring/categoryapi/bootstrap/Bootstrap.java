package learn.spring.categoryapi.bootstrap;

import learn.spring.categoryapi.model.Category;
import learn.spring.categoryapi.model.Customer;
import learn.spring.categoryapi.repository.CategoryRepository;
import learn.spring.categoryapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        loadCategoryData();
        loadCustomerData();
    }

    private void loadCategoryData() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.saveAll(List.of(fruits, dried, fresh, exotic, nuts));
        log.info("{} categories loaded.", categoryRepository.count());
    }

    private void loadCustomerData() {
        Customer customer = new Customer();
        customer.setFirstName("Ivan");
        customer.setLastName("Wang");

        Customer customer2 = new Customer();
        customer2.setFirstName("Joe");
        customer2.setLastName("Doe");

        Customer customer3 = new Customer();
        customer3.setFirstName("Jimmy");
        customer3.setLastName("Chou");

        customerRepository.saveAll(List.of(customer, customer2, customer3));
        log.info("{} customers loaded", customerRepository.count());

    }
}
