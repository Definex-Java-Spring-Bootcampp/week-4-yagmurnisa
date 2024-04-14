package com.patika.kredinbizdeservice.client.dto.request;

import java.math.BigDecimal;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AkbankCardApplicationRequest {

	private String email;
    
    private Long cardId;	
}
