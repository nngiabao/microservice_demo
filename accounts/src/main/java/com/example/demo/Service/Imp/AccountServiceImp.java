package com.example.demo.Service.Imp;

import com.example.demo.Constants.AccountConstants;
import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Entity.Account;
import com.example.demo.Entity.Customer;
import com.example.demo.Exception.CustomerAlreadyExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Mapper.AccountMapper;
import com.example.demo.Mapper.CustomerMapper;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        customer.setCreatedAt(LocalDateTime.now());
        accountRepository.save(createNewAccount(savedCustomer));
        //
        //accountRepository.save();

    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        //orElseThrow => if not found
        //we inject this customer that we get
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
         //account
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account","mobileNumber",mobileNumber)
        );
        CustomerDTO customerDto = CustomerMapper.mapToCustomerDto(customer,new CustomerDTO());
        customerDto.setAccount(AccountMapper.mapToAccountsDto(account,new AccountDTO()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        //
        AccountDTO accountDTO = customerDTO.getAccount();
        //
        if(accountDTO != null){
            Account account = accountRepository.findById(accountDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account","AccountNumber",accountDTO.getAccountNumber().toString())
            );
            AccountMapper.mapToAccounts(accountDTO,account);
            account = accountRepository.save(account);
            //
            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer","customerId",customerDTO.getCustomerId().toString() )
            );
            CustomerMapper.mapToCustomerDto(customer,customerDTO);
            customerRepository.save(customer);
            //if true
            isUpdated = true;
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

}
