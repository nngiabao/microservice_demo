package com.example.demo.Service.Imp;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImp implements AccountService {
    //
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    //
    @Override
    public void createAccount(Account account) {

    }
}
