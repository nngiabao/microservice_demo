package com.example.demo.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;

    private AccountDTO account;
}
