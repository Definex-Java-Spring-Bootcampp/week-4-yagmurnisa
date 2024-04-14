package com.patika.kredinbizdeservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
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
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceTest {
	@InjectMocks
    private	CreditCardService creditCardService;

	@Mock
	private CreditCardRepository creditCardRepository;

/*	@Test
	public void should_get_all_cards_successfully() {
		//given
		Mockito.when(creditCardRepository.findAll()).thenReturn(prepareCards());
	}
	
	@Test
	public void should_get_cards_by_bank_successfully() {
		//given
		Mockito.when(creditCardRepository.findByBankName(prepareCard().getBank().getName())).thenReturn(prepareCards());
	}
	*/
	@Test
	public void should_get_card_by_id_successfully() {
		//given
		Mockito.when(creditCardRepository.findById(prepareCard().getId())).thenReturn(Optional.of(prepareCard()));
		
		CreditCard card = creditCardService.getCardById(prepareCard().getId());

		assertThat(card).isNotNull();	
		assertThat(card.getId()).isEqualTo(prepareCard().getId());
		assertThat(card.getBank().getId()).isEqualTo(prepareCard().getBank().getId());
		assertThat(card.getBank().getName()).isEqualTo(prepareCard().getBank().getName());
	
		verify(creditCardRepository, times(1)).findById(prepareCard().getId());

	}
	
	@Test
    public void should_throw_kredinbizdeException_whenCardNotFound() {
        //given

        //when
        Throwable throwable = catchThrowable(() -> creditCardService.getCardById(prepareCard().getId()));

        //then
        assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.CARD_NOT_FOUND);
    }
	
	private CreditCard prepareCard() {
		CreditCard card = new CreditCard();
		card.setId(1L);
		Bank bank = new Bank();
		bank.setId(1L);
		bank.setName("test bank");
		card.setBank(bank);
		return card;
		
	}
	/*private List<CreditCard> prepareCards(){
		
	}*/

}
