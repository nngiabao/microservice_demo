package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
//this class for send error
public class ErrorResponseDTO {
    private String errorMessage;
    private HttpStatus httpStatus;
    private String details;
    private LocalDateTime errorTime;
}
