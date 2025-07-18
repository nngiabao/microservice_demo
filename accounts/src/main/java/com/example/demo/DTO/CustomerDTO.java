package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CustomerDTO {
    private Long customerId;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 5, max = 30,message = "The length of the customer name ...")
    private String name;

    @NotEmpty(message = "cannot empty")
    @Email(message = "email fail")
    private String email;

    @Pattern(regexp = "($|[0-9]{10})")
    private String mobileNumber;

    private AccountDTO account;
}
