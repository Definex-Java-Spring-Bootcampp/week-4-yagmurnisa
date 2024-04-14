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

import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Loan;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.patika.kredinbizdeservice.repository.LoanRepository;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {
	
	@InjectMocks
    private	LoanService loanService;

	@Mock
	private LoanRepository loanRepository;

	
	@Test
	public void should_get_loan_by_id_successfully() {
		//given
		Mockito.when(loanRepository.findById(prepareLoan().getId())).thenReturn(Optional.of(prepareLoan()));
		
		Loan loan = loanService.getLoanById(prepareLoan().getId());

		assertThat(loan).isNotNull();	
		assertThat(loan.getId()).isEqualTo(prepareLoan().getId());
		assertThat(loan.getBank().getId()).isEqualTo(prepareLoan().getBank().getId());
		assertThat(loan.getBank().getName()).isEqualTo(prepareLoan().getBank().getName());
	
		verify(loanRepository, times(1)).findById(prepareLoan().getId());
	}
	
	@Test
    public void should_throw_kredinbizdeException_whenLoanNotFound() {
        //given

        //when
        Throwable throwable = catchThrowable(() -> loanService.getLoanById(prepareLoan().getId()));

        //then
        assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.LOAN_NOT_FOUND);
    }
	
	
	private Loan prepareLoan() {
		Loan loan = new Loan();
		loan.setId(1L);
		Bank bank = new Bank();
		bank.setId(1L);
		bank.setName("test bank");
		loan.setBank(bank);
		return loan;
	}
}

