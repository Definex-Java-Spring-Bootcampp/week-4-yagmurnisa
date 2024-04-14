package com.patika.kredinbizdeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Loan;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	List<CreditCard> findByBankId(Long bankId);
}
