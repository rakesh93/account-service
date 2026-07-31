package com.ilearn.account_service.model;

import java.time.LocalDateTime;

import com.ilearn.account_service.util.AppConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "accountdetail", uniqueConstraints = { @UniqueConstraint(columnNames = "account_number"),
		@UniqueConstraint(columnNames = "aadhar_number"), @UniqueConstraint(columnNames = "mobile_number") })
public class AccountModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "account_type")
	private String accountType;
	@Column(name = "account_number")	
	private String accountNumber;
	@Column(name = "aadhar_number")
	@NotBlank(message = AppConstants.AADHAR_NUMBER)
	@Pattern(regexp = "^\\d{12}$", message = AppConstants.AADHAR_NUMBER_DIGITS)
	private String aadharNumber;
	@Column(name = "mobile_number")
	@NotBlank(message = AppConstants.MOBILE_NUMBER)
	@Pattern(regexp = "^\\d{10}$", message = AppConstants.MOBILE_NUMBER_DIGITS)
	private String mobileNumber;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createdDate;

	public AccountModel() {
	}

	public AccountModel(Long accountId, String firstName, String lastName, String accountType, String accountNumber,
			String aadharNumber, String mobileNumber, boolean isActive) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.aadharNumber = aadharNumber;
		this.mobileNumber = mobileNumber;
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedDate() {
	    return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
	    this.createdDate = createdDate;
	}
	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "AccountModel [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountType=" + accountType + ", accountNumber=" + accountNumber + ", aadharNumber=" + aadharNumber
				+ ", mobileNumber=" + mobileNumber + ", isActive=" + isActive + ", createdDate=" + createdDate + "]";
	}

}
