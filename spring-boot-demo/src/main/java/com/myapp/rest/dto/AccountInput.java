package com.myapp.rest.dto;



import javax.validation.constraints.NotBlank;


// DTO Classes (Data Transfer Objects)
public class AccountInput {
	
	@NotBlank(message ="Account Number is Mandatory")
	private String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	
	
	

}
