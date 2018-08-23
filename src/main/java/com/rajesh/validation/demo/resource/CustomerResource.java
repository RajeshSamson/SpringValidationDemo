package com.rajesh.validation.demo.resource;

import com.rajesh.validation.demo.model.Customer;
import com.rajesh.validation.demo.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerResource {

    private final CustomerRepository customerRepository;

    public CustomerResource(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/customer/all")
    public List<Customer> getCustomerDetails() {
        return customerRepository.findAll();
    }

    @PostMapping(path = "/customer/save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }
}
