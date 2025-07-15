package com.example.demo.Repository;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //
    Optional<Account> findByCustomerId(Long customerId);
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
