package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.enums.VehicleStatusType;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("vehicle")
public class VehicleLoan extends Loan  {

    //private LoanType loanType = LoanType.ARAC_KREDISI;
	//@Column(name="vehicle_status")
	//private VehicleStatusType vehicleStatus;
  
    void calculate(BigDecimal amount, int installment) {
        //istediği kadar ödeme yapabilir.
    }
}
