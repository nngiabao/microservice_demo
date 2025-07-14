package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private Long id;
    //
    @Column(name="account_number")
    private Long accountNumber;
    //
    @Column(name="account_type")
    private String accountType;
    //
    private String branchAddress;
}
