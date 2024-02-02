package com.springtask1.bankingapp.service.entityservice;

import com.springtask1.bankingapp.entity.Customer;
import com.springtask1.bankingapp.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerEntityService {

    private CustomerRepository customerRepository;

    public CustomerEntityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        customer = customerRepository.save(customer);
        return customer;
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public Customer findById(Long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.get();
    }

    public List<Customer> findByIdentityNo(Long identityNo){
        List<Customer> customerIdentity = customerRepository.findByIdentityNo(identityNo);
        return customerIdentity;
    }

    public List<Customer> findByEmailWithQuery(String email){
        List<Customer> customerEmail = customerRepository.findByEmailWithQuery(email);
        return customerEmail;
    }
}
