package com.patika.kredinbizdeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.repository.CampaignRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampaignService {
	
	private final CampaignRepository campaignRepository;
	
	public List<Campaign> getByCard(Long id) {
		//return campaignRepository.findByCreditCard(id);
		return new ArrayList<Campaign>();
	}

	public List<Campaign> getAll() {
		return new ArrayList<Campaign>();
	}
	
	public Campaign getById(Long id) {
		Optional<Campaign> found = campaignRepository.findById(id);
		Campaign campaign = found.orElseThrow(() -> new KredinbizdeException(ExceptionMessages.CAMPAIGN_NOT_FOUND));
		return campaign;
	}
}
