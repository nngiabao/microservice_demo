package com.example.demo.Repository;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountRepository {
    //autowire
    AccountService accountService;
     //
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody Account account) {

    }
    //
}
