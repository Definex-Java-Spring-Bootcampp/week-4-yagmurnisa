package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("house")
public class HouseLoan extends Loan {

   // private LoanType loanType = LoanType.KONUT_KREDISI;

    
    void calculate(BigDecimal amount, int installment) {

    }
}
