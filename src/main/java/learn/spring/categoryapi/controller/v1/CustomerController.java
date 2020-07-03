package learn.spring.categoryapi.controller.v1;

import learn.spring.categoryapi.api.v1.model.CustomerDTO;
import learn.spring.categoryapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<CustomerDTO> getCustomerByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(customerService.getCustomerByFirstName(firstName), HttpStatus.OK);
    }
}
