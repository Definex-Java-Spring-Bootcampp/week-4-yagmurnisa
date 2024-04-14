package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.LoanApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

	List<LoanApplication> findByUserId(Long id);
}
