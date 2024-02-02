package com.springtask1.bankingapp.controller;

import com.springtask1.bankingapp.entity.Account;
import com.springtask1.bankingapp.entity.Customer;
import com.springtask1.bankingapp.service.entityservice.AccountEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private AccountEntityService accountEntityService;

    public AccountController(AccountEntityService accountEntityService) {
        this.accountEntityService = accountEntityService;
    }

    @PostMapping("/save")
    public Account save(@RequestBody Account account){
        account = accountEntityService.saveAccount(account);
        return account;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Account account){
        accountEntityService.deleteAccount(account);
    }

    @GetMapping
    public List<Account> getByIbanNoWithQuery(@RequestParam String ibanNo){
        List<Account> accountIbanNo = accountEntityService.findByIbanNoWithQuery(ibanNo);
        return accountIbanNo;
    }

    @GetMapping("/{customerId}")
    public List<Account> getByCustomerId(@RequestParam Long customerId){
        List<Account> accountCustomerId = accountEntityService.findByCustomerId(customerId);;
        return accountCustomerId;
    }
}
