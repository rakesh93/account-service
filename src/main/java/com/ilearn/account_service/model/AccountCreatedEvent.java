package com.ilearn.account_service.model;

public class AccountCreatedEvent {

	private String accountNumber;
	private String firstName;
	private String lastName;
	private String mobileNumber;

	public AccountCreatedEvent() {}

	public AccountCreatedEvent(String accountNumber, String firstName, String lastName, String mobileNumber) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "AccountCreatedEvent [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + "]";
	}
	
}
