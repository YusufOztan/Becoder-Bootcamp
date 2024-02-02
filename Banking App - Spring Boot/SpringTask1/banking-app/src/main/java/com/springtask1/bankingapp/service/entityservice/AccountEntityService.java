package com.springtask1.bankingapp.service.entityservice;

import com.springtask1.bankingapp.entity.Account;
import com.springtask1.bankingapp.entity.Customer;
import com.springtask1.bankingapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountEntityService {
    private AccountRepository accountRepository;

    public AccountEntityService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account){
        account = accountRepository.save(account);
        return account;
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }

    public List<Account> findByIbanNoWithQuery(String ibanNo){
        List<Account> accountIbanNo = accountRepository.findByIbanNoWithQuery(ibanNo);
        return accountIbanNo;
    }

    public List<Account> findByCustomerId(Long customerId) {
        List<Account> accountCustomerId = accountRepository.findByCustomerId(customerId);
        return accountCustomerId;
    }
}
