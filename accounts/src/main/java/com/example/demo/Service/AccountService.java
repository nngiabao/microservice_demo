package com.example.demo.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Entity.Account;

public interface AccountService {
    public void createAccount(CustomerDTO customerDTO);
    public CustomerDTO fetchAccount(String accountId);
    //update
    boolean updateAccount(CustomerDTO customerDTO);
    boolean deleteAccount(String accountId);
}
