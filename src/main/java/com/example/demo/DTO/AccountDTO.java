package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountDTO {
    Long id;
    //
    private Long accountNumber;
    private String accountName;
    private String accountType;
    private String branchAddress;
     //
     //
}
