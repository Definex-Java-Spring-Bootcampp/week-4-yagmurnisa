package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.client.dto.request.AkbankCardApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.request.AkbankLoanApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.CardApplicationRequest;
import com.patika.kredinbizdeservice.dto.request.LoanApplicationRequest;
import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.LoanApplication;
import com.patika.kredinbizdeservice.model.CardApplication;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.repository.CardApplicationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CardApplicationRepository cardApplicationRepository;
    private final ApplicationConverter applicationConverter;
    private final UserService userService;
    private final AkbankServiceClient akbankServiceClient;
    //private final GarantiServiceClient garantiServiceClient;

    public LoanApplication createLoanApplication(LoanApplicationRequest request) {

        User user = userService.getByEmail(request.getEmail());
        log.info("user bulundu");

        LoanApplication application = applicationConverter.toLoanApplication(request, user);

        ApplicationResponse applicationResponse = handleLoanApplication(request);

        if (applicationResponse == null) {
        	throw new KredinbizdeException(ExceptionMessages.APPLICATON_CREATION_ERROR);
        }

        LoanApplication savedApplication = applicationRepository.save(application);

        return savedApplication;
    }
    
    public CardApplication createCardApplication(CardApplicationRequest request) {
    	
    	User user = userService.getByEmail(request.getEmail());
        log.info("user bulundu");

        CardApplication application = applicationConverter.toCardApplication(request, user);

        ApplicationResponse applicationResponse = handleCardApplication(request);

        if (applicationResponse == null) {
        	throw new KredinbizdeException(ExceptionMessages.APPLICATON_CREATION_ERROR);
        }

        CardApplication savedApplication = cardApplicationRepository.save(application);

        return savedApplication;
    }
    
  /*  public List<Application> getApplicationsByUser(Long id) {
    	
    	return applicationRepository.findAllByUserId(id);
    }*/

    public LoanApplication getLoanById(Long id) {
    	
    	Optional<LoanApplication> foundApp = applicationRepository.findById(id);
    	LoanApplication application = foundApp.orElseThrow(() -> new KredinbizdeException(ExceptionMessages.APPLICATON_NOT_FOUND));
    	return application;
    }
    
    public CardApplication getCardById(Long id) {
    	
    	Optional<CardApplication> foundApp = cardApplicationRepository.findById(id);
    	CardApplication application = foundApp.orElseThrow(() -> new KredinbizdeException(ExceptionMessages.APPLICATON_NOT_FOUND));
    	return application;
    }
    
    public List<LoanApplication> getLoansByUser(Long id) {
    	List<LoanApplication> loans = applicationRepository.findByUserId(id);
    	return loans;
    }
    
    public List<CardApplication> getCardsByUser(Long id) {
    	List<CardApplication> cards = cardApplicationRepository.findByUserId(id);
    	return cards;
    }
    
    private ApplicationResponse handleLoanApplication(LoanApplicationRequest request) {
    	
    	String bankName = request.getBank().getName().toLowerCase();
    	ApplicationResponse applicationResponse = null;
    	if (bankName.equals("akbank")) {
    		applicationResponse = akbankServiceClient.createLoanApplication(prepareAkbankApplicationRequest(request));
    	}
    	else if (bankName.equals("garanti")) {
    		
    	}
    	return applicationResponse;
    }
    
    private ApplicationResponse handleCardApplication(CardApplicationRequest request) {
    	
    	String bankName = request.getBank().getName().toLowerCase();
    	ApplicationResponse applicationResponse = null;
    	if (bankName.equals("akbank")) {
    		applicationResponse = akbankServiceClient.createCardApplication(prepareAkbankApplicationRequest(request));
    	}
    	else if (bankName.equals("garanti")) {
    		
    	}
    	return applicationResponse;
    }

    private AkbankLoanApplicationRequest prepareAkbankApplicationRequest(LoanApplicationRequest request) {
    	
        AkbankLoanApplicationRequest applicationRequest = new AkbankLoanApplicationRequest();

        applicationRequest.setEmail(request.getEmail());
        applicationRequest.setAmount(request.getAmount());
        applicationRequest.setInstallment(request.getInstallment());
        applicationRequest.setLoanId(request.getLoanId());
        return applicationRequest;
    }
    
    private AkbankCardApplicationRequest prepareAkbankApplicationRequest(CardApplicationRequest request) {
	
    AkbankCardApplicationRequest applicationRequest = new AkbankCardApplicationRequest();

    applicationRequest.setEmail(request.getEmail());
    applicationRequest.setCardId(request.getCardId());
    return applicationRequest;
    }
}
