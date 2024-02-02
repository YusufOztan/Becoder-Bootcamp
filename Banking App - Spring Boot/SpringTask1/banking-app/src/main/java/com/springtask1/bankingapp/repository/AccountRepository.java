package com.springtask1.bankingapp.repository;

import com.springtask1.bankingapp.entity.Account;
import com.springtask1.bankingapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("select a from Account a where a.ibanNo = :ibanNo")
    List<Account> findByIbanNoWithQuery(String ibanNo);
    List<Account> findByCustomerId(Long customerId);
}
