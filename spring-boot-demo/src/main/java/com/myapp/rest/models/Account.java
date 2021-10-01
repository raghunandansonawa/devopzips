package com.myapp.rest.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="accounts",schema  ="my_bank")
public class Account {
	
	@Id
	
	private long id;
	
	private String accountNumber;
	
	private Double currentBalance;
	
	private String bankName;
	
	@Column(name = "owner_name")
	private String accountHolderName;
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	public Account(long id, String accountNumber, Double currentBalance, String bankName, String accountHolderName) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.accountHolderName = accountHolderName;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountHolderName, accountNumber, bankName, currentBalance, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountHolderName, other.accountHolderName)
				&& Objects.equals(accountNumber, other.accountNumber) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(currentBalance, other.currentBalance) && id == other.id;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", currentBalance=");
		builder.append(currentBalance);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", accountHolderName=");
		builder.append(accountHolderName);
		builder.append("]");
		return builder.toString();
	}


	


	
	


	
	
	
	

}
