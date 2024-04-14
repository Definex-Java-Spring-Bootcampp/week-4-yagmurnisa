package com.patika.kredinbizdeservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.service.BankService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/banks")
@RequiredArgsConstructor
public class BankController {

	private final BankService bankService;
	
	@GetMapping
	public List<Bank> getAll() {
		return bankService.getAll();
	}
	
	@GetMapping("/name/{name}")
	public Bank getByName(@PathVariable String name) {
		return bankService.getByName(name);
	}
	
	@GetMapping("/id/{id}")
	public Bank getById(@PathVariable Long id) {
		return bankService.getById(id);
	}
}
