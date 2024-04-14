package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.dto.request.CardApplicationRequest;
import com.patika.kredinbizdeservice.dto.request.LoanApplicationRequest;
import com.patika.kredinbizdeservice.model.CardApplication;
import com.patika.kredinbizdeservice.model.LoanApplication;
import com.patika.kredinbizdeservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/loans")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanApplication createLoanApplication(@RequestBody LoanApplicationRequest request) {
        return applicationService.createLoanApplication(request);
    }
    
    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    public CardApplication createCardApplication(@RequestBody CardApplicationRequest request) {
        return applicationService.createCardApplication(request);
    }
    
   /* public List<Application> getApplicationsByUser(@RequestBody Long id) {
    	return applicationService.getApplicationsByUser(id);
    }*/

}
