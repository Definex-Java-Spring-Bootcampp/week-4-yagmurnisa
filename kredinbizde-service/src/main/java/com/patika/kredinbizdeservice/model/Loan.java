package com.patika.kredinbizdeservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.kredinbizdeservice.enums.ApplicationStatus;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "loan_type")
@Table(name= "loans")
public abstract class Loan  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	private String name;

	@Transient // belirli bir değer yok kullanıcı başvurusunda belirliyor
    private BigDecimal amount;

	@Transient
    private Integer installment;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    
	@Column(name="interest_rate")
    private Double interestRate;
    // private Campaign campaign; // kampanyalı kredileri üstte çıkart

	//sponsorlu kampanyaları üstte çıkart

	// abstract void calculate(BigDecimal amount, int installment);
}
