package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue("consumer")
public class ConsumerLoan extends Loan {

   // private LoanType loanType = LoanType.IHTIYAC_KREDISI;
  //  private List<Integer> installmentOptions;

  
    void calculate(BigDecimal amount, int installment) {
        //tc bul, maaşı bul
    }

}
