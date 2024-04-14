package com.patika.kredinbizdeservice.client.dto.request;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AkbankLoanApplicationRequest {

	private String email;
    
    private Long loanId;	

    private BigDecimal amount;

    private Integer installment;
    
   // private Double interestRate;

}