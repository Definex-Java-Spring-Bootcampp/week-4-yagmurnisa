package com.patika.kredinbizdeservice.dto.request;

import java.math.BigDecimal;

import com.patika.kredinbizdeservice.model.Bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationRequest {

    private String email;
    
    private Long loanId;	

    private BigDecimal amount;

    private Integer installment;
    
 //   private Double interestRate;
    
    private Bank bank;
}
