package com.patika.kredinbizdeservice.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banks")
public class Bank {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
    private String name;
    
    /*@JsonIgnore
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Loan> loanList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL) 
    private List<CreditCard> creditCards;*/

}
