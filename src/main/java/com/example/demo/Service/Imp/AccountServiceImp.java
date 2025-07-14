package com.example.demo.Service.Imp;

import com.example.demo.Conmstants.AccountConstants;
import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Entity.Account;
import com.example.demo.Entity.Customer;
import com.example.demo.Exception.CustomerAlreadyExistsException;
import com.example.demo.Mapper.CustomerMapper;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    //
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        //
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        //
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists" + customerDTO.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
        //
        //accountRepository.save();

    }

    //private method
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }
    /*

    //
    @Override
    public void createAccount(Account account) {
        Account newAccount = new Account();
        newAccount.set
    }

    public CustomerDTO fecthAccount(String mobileNumber){
        customerRepository.findBynumber()
                return null;
    }
    */

}
