package com.patika.kredinbizdeservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.CreditCardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CreditCardController {

	private final CreditCardService creditCardService;
		
	@GetMapping("/bank/{bankId}")
	public List<CreditCard> getLoansByBank(@PathVariable Long bankId) {
		return creditCardService.getCardsByBank(bankId);
	}
	@GetMapping
	public List<CreditCard> getAllLoans() {
		return creditCardService.getAllCards();
	}
	@GetMapping("/{id}")
	public CreditCard getLoanById(@PathVariable Long id) {
		return creditCardService.getCardById(id);

	}
}
