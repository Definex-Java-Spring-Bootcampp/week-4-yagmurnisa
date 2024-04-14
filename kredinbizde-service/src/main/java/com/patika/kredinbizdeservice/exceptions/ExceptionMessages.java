package com.patika.kredinbizdeservice.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

   /* private ExceptionMessages(){

    }*/

    public static final String USER_NOT_FOUND = "User not found";
    public static final String BANK_NOT_FOUND = "Bank not found";
    public static final String LOAN_NOT_FOUND = "Loan not found";
    public static final String CARD_NOT_FOUND = "Card not found";
    public static final String APPLICATON_NOT_FOUND = "Application not found";
    public static final String APPLICATON_CREATION_ERROR = "Application creation error";
	public static final String CAMPAIGN_NOT_FOUND = "Campaign not found";
	public static final String PASSWORD_NOT_MATCH = "Passwords do not match";
	public static final String EMAIL_TAKEN = "Email is taken";

}
