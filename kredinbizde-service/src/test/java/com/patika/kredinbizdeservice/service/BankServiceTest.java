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
import com.patika.kredinbizdeservice.repository.BankRepository;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {
	@InjectMocks
    private	BankService bankService;

	@Mock
	private BankRepository bankRepository;

	/*@Test
	/public void should_get_all_banks_successfully() {
		//given
		Mockito.when(bankRepository.findAll()).thenReturn(prepareBanks());
	}*/
	
	@Test
	public void should_get_bank_by_id_successfully() {
		//given
		Mockito.when(bankRepository.findById(prepareBank().getId())).thenReturn(Optional.of(prepareBank()));
		
		Bank bank = bankService.getById(prepareBank().getId());
		
		assertThat(bank).isNotNull();	
		assertThat(bank.getId()).isEqualTo(prepareBank().getId());
		assertThat(bank.getName()).isEqualTo(prepareBank().getId());
	
		verify(bankRepository, times(1)).findById(prepareBank().getId());
	}
	
	@Test
	public void should_get_bank_by_name_successfully() {
		//given
		Mockito.when(bankRepository.findByName(prepareBank().getName())).thenReturn(Optional.of(prepareBank()));
	
		Bank bank = bankService.getByName(prepareBank().getName());
		
		assertThat(bank).isNotNull();	
		assertThat(bank.getId()).isEqualTo(prepareBank().getId());
		assertThat(bank.getName()).isEqualTo(prepareBank().getId());
	
		verify(bankRepository, times(1)).findByName(prepareBank().getName());
	}

    @Test
    public void should_throw_kredinbizdeException_whenBankNotFoundById() {
        //given

        //when
        Throwable throwable = catchThrowable(() -> bankService.getById(prepareBank().getId()));

        //then
        assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.BANK_NOT_FOUND);
    }
    
    @Test
    public void should_throw_kredinbizdeException_whenBankNotFoundByName() {
        //given

        //when
        Throwable throwable = catchThrowable(() -> bankService.getByName(prepareBank().getName()));

        //then
        assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.BANK_NOT_FOUND);
    }
    
	private Bank prepareBank(){
		
		Bank bank = new Bank();
		bank.setId(1L);
		bank.setName("test name");
		return bank;
	}
	
}
