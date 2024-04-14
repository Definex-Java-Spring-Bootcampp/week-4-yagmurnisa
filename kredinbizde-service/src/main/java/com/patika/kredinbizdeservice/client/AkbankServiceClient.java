package com.patika.kredinbizdeservice.client;

import com.patika.kredinbizdeservice.client.dto.request.AkbankCardApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.request.AkbankLoanApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "akbank-service", url = "localhost:8081")
public interface AkbankServiceClient {

    @PostMapping("api/akbank/v1/applications/loans")
    ApplicationResponse createLoanApplication(@RequestBody AkbankLoanApplicationRequest request);
    @PostMapping("api/akbank/v1/applications/cards")
    ApplicationResponse createCardApplication(@RequestBody AkbankCardApplicationRequest request);
}
