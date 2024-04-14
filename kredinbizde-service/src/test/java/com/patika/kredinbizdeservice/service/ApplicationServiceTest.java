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

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.LoanApplicationRequest;
import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.LoanApplication;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.LoanApplicationRepository;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {
	
	@InjectMocks
	ApplicationService applicationService;
	
	@Mock
	LoanApplicationRepository applicationRepository;
	
	@Mock 
	UserService userService;
	
	@Mock
    AkbankServiceClient akbankServiceClient;
	
	@Mock
	ApplicationConverter applicationConverter;

	@Test
	public void should_create_application_successfully() {
		//given
		Mockito.when(userService.getByEmail(prepareUser().getEmail())).thenReturn(prepareUser());
		Mockito.when(applicationConverter.toLoanApplication(Mockito.any(LoanApplicationRequest.class), Mockito.any(User.class))).thenReturn(prepareApplication());
		Mockito.when(applicationRepository.save(Mockito.any(LoanApplication.class))).thenReturn(prepareApplication());
		Mockito.when(akbankServiceClient.createLoanApplication(null)).thenReturn(prepareApplicationResponse());
		//when
		LoanApplication application = applicationService.createLoanApplication(prepareApplicationRequest());
		//then
		assertThat(application).isNotNull();
		assertThat(application.getId()).isEqualTo(prepareApplication().getId());
        assertThat(application.getUser().getName()).isEqualTo(prepareUser().getName());
        assertThat(application.getUser().getSurname()).isEqualTo(prepareUser().getSurname());
        assertThat(application.getUser().getEmail()).isEqualTo(prepareUser().getEmail());
        assertThat(application.getUser().getPassword()).isEqualTo(prepareUser().getPassword());
        
        verify(applicationRepository, times(1)).save(Mockito.any(LoanApplication.class));

	}
	
	@Test
	public void should_throw_kredinbizdeException_whenApplicationNotCreated() {
		
		Throwable throwable = catchThrowable(() -> applicationService.createLoanApplication(prepareApplicationRequest()));
		
		assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.APPLICATON_CREATION_ERROR);
	}
	
	@Test
	public void should_return_application_by_id() {
		
		Mockito.when(applicationRepository.findById(prepareApplication().getId())).thenReturn(Optional.of(prepareApplication()));
		
		LoanApplication application = applicationService.getLoanById(prepareApplication().getId());
	
		assertThat(application).isNotNull();
		assertThat(application.getId()).isEqualTo(prepareApplication().getId());
       
        verify(applicationRepository, times(1)).findById(prepareUser().getId());
	}
	
	@Test 
	public void should_throw_kredinbizdeException_whenApplicationNotFound() {
		
		Throwable throwable = catchThrowable(() -> applicationService.getLoanById(prepareApplication().getId()));
		assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo(ExceptionMessages.APPLICATON_NOT_FOUND);
	}

	private LoanApplication prepareApplication() {
		
		LoanApplication app = new LoanApplication();
		app.setId(1L);
		app.setUser(prepareUser());
		return app;
	}
	
    private User prepareUser() {
        User user = new User();
        user.setName("test name");
        user.setSurname("test surname");
        user.setEmail("test@gmail.com");
        user.setPassword("password");
        user.setIsActive(true);
        return user;
    }

	private ApplicationResponse prepareApplicationResponse() {
		return new ApplicationResponse();
	}
	
	private LoanApplicationRequest prepareApplicationRequest() {
		return new LoanApplicationRequest();
	} 
}
