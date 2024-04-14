package com.patika.kredinbizdeservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.CampaignRepository;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceTest {
	/*
	@InjectMocks
	private CampaignService campaignService;

	@Mock
	private CampaignRepository campaignRepository;
	
	@Test
	public void should_get_campaign_by_id_successfully() {
		//given
		Mockito.when(campaignRepository.findById(prepareCampaign().getId())).thenReturn(Optional.of(prepareCampaign()));
		
		Campaign campaign = campaignService.getById(prepareCampaign().getId());

		assertThat(campaign).isNotNull();	
		assertThat(campaign.getId()).isEqualTo(prepareCampaign().getId());
		assertThat(campaign.getTitle()).isEqualTo(prepareCampaign().getTitle());
		assertThat(campaign.getContent()).isEqualTo(prepareCampaign().getContent());
		assertThat(campaign.getBank().getId()).isEqualTo(prepareCampaign().getBank().getId());
		assertThat(campaign.getBank().getName()).isEqualTo(prepareCampaign().getBank().getName());
	
		verify(campaignRepository, times(1)).findById(prepareCampaign().getId());
	}
	
	@Test
    public void should_throw_kredinbizdeException_whenLoanNotFound() {
        //given

        //when
        Throwable throwable = catchThrowable(() -> campaignService.getById(prepareCampaign().getId()));

        //then
        assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.CAMPAIGN_NOT_FOUND);
    }
	
	private Campaign prepareCampaign() {
		Campaign campaign = new Campaign();
		campaign.setId(1L);
		campaign.setTitle("test title");
		campaign.setContent("test content");
		Bank bank = new Bank();
		bank.setId(1L);
		bank.setName("test bank");
		campaign.setBank(bank);
		return campaign;
		
	}*/
}
