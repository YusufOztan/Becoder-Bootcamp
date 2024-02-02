package com.springtask1.bankingapp.controller;

import com.springtask1.bankingapp.entity.Customer;
import com.springtask1.bankingapp.repository.CustomerRepository;
import com.springtask1.bankingapp.service.entityservice.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerEntityService customerEntityService;

    public CustomerController(CustomerEntityService customerEntityService) {
        this.customerEntityService = customerEntityService;
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        customer = customerEntityService.saveCustomer(customer);
        return customer;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Customer customer){
        customerEntityService.deleteCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        Customer customer = customerEntityService.findById(id);
        return customer;
    }
    @GetMapping
    public List<Customer> getByIdentityNo(@RequestParam Long identityNo){
        List<Customer> customerIdentity = customerEntityService.findByIdentityNo(identityNo);
        return customerIdentity;
    }

    @GetMapping("/{email}")
    public List<Customer> getByEmailWithQuery(@RequestParam String email){
        List<Customer> customerEmail = customerEntityService.findByEmailWithQuery(email);
        return customerEmail;
    }


}
