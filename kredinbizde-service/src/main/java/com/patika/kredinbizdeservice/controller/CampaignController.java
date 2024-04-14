package com.patika.kredinbizdeservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.service.CampaignService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/campaigns")
@RequiredArgsConstructor
public class CampaignController {

	private final CampaignService campaignService;
	
	@GetMapping
	public List<Campaign> getAll() {
		return campaignService.getAll();
	}
	
	@GetMapping("/{id}")
	public Campaign getById(@PathVariable Long id) {
		return campaignService.getById(id);
	}
	
	@GetMapping("/card/{cardId}")
	public List<Campaign> getByCardName(@PathVariable Long cardId) {
		return campaignService.getByCard(cardId);
	}
}
