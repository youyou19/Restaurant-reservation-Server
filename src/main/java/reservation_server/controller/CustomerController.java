package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.Customer;
import reservation_server.exception.NotFoundException;
import reservation_server.service.CustomerService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customers")
    public Customer newCustomer(@RequestBody Customer customer) {
        Customer byEmail = customerService.findByEmail(customer.getEmail());
        if (byEmail != null) return null;
        return customerService.save(customer);
    }

    @PutMapping(value = "/customers")
    public Customer replaceCustomer(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }
}
