package com.patika.kredinbizdeservice.dto.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.kredinbizdeservice.model.Bank;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

	private Long id;	

    private BigDecimal amount;

    private Integer installment;
    
    private Double interestRate;
    
    private String bankName;
}
