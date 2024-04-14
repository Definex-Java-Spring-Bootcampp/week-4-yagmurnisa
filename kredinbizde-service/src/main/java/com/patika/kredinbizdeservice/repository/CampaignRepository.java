package com.patika.kredinbizdeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patika.kredinbizdeservice.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

	//List<Campaign> findByCreditCard(Long id);
}
