package com.patika.kredinbizdeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.LoanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanService {
	
	private final LoanRepository loanRepository;

	public List<Loan> getLoansByBank(Long bankId) {
		return loanRepository.findByBankId(bankId);
	}

	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}
	
	public Loan getLoanById(Long id) {
		Optional<Loan> foundLoan = loanRepository.findById(id);
        Loan loan = foundLoan.orElseThrow(() -> new KredinbizdeException(ExceptionMessages.LOAN_NOT_FOUND));
		return loan;
	}
}
