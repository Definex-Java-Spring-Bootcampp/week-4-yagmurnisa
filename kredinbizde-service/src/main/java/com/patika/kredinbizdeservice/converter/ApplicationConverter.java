package com.patika.kredinbizdeservice.converter;

import com.patika.kredinbizdeservice.dto.request.CardApplicationRequest;
import com.patika.kredinbizdeservice.dto.request.LoanApplicationRequest;
import com.patika.kredinbizdeservice.enums.ApplicationStatus;
import com.patika.kredinbizdeservice.model.LoanApplication;
import com.patika.kredinbizdeservice.model.Audit;
import com.patika.kredinbizdeservice.model.CardApplication;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ApplicationConverter {

    public LoanApplication toLoanApplication(LoanApplicationRequest request, User user) {
        LoanApplication application = new LoanApplication();
        application.setUser(user);
        application.setInstallment(request.getInstallment());
        application.setApplicationStatus(ApplicationStatus.INITIAL);
        application.setAmount(request.getAmount());
        application.setCreatedDate(LocalDate.now());
        application.setUpdatedDate(LocalDate.now());
        return application;
    }
    
    public CardApplication toCardApplication(CardApplicationRequest request, User user) {
    	CardApplication application = new CardApplication();
    	CreditCard card = new CreditCard();
    	card.setId(request.getCardId());
        application.setUser(user);
        application.setApplicationStatus(ApplicationStatus.INITIAL);
        application.setCard(card);
        application.setCreatedDate(LocalDate.now());
        application.setUpdatedDate(LocalDate.now());
        return application;
    }
}
