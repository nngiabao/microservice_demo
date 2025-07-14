package com.example.demo.Controller;

import com.example.demo.Conmstants.AccountConstants;
import com.example.demo.DTO.CustomerDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountService;
import lombok.AllArgsConstructor;
import org.apache.catalina.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201,AccountConstants.STATUS_200));
    }
    //
    public ResponseEntity<CustomerDTO> fecthAccountDetail(@RequestParam String mobileNumber){
        return null;
    }
}
