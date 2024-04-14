package com.patika.kredinbizdeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditCardService {
	
	private final CreditCardRepository creditCardRepository;
	
	public List<CreditCard> getCardsByBank(String bankName) {
		return creditCardRepository.findByBankName(bankName);
	}

	public List<CreditCard> getAllCards() {
		return creditCardRepository.findAll();
	}
	
	public CreditCard getCardById(Long id) {
		Optional<CreditCard> foundCard = creditCardRepository.findById(id);
		CreditCard card = foundCard.orElseThrow(() -> new KredinbizdeException(ExceptionMessages.USER_NOT_FOUND));
		return card;
	}
}
