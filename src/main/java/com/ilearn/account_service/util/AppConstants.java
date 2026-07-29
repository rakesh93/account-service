package com.ilearn.account_service.util;

public class AppConstants {

	// API Response Code
	public static final int SUCCESS = 200;
	public static final int FAILURE = 400;
	public static final int NOT_FOUND = 404;
	public static final int SERVER_ERROR = 500;

	// Message Value Constant
	public static final String CREATED = "Successfully Created Account";
	public static final String NOT_CREATED = "Failure To Create Account";
	public static final String UPDATED = "Account Updated Successfully";
	public static final String NOT_UPDATED = "Failure To Update Account";
	public static final String DELETED = "Account Deleted Successfully";
	public static final String ACCOUNT_NUMBER = "Account Number is Required";
	public static final String AADHAR_NUMBER = "Aadhar Number is Required";
	public static final String MOBILE_NUMBER = "Mobile Number is Required";
	public static final String ACCOUNT_NUMBER_DUPLICATE = "Account Number is Duplicate";
	public static final String AADHAR_NUMBER_DUPLICATE  = "Aadhar Number is Duplicate";
	public static final String MOBILE_NUMBER_DUPLICATE  = "Mobile Number is Duplicate";
	public static final String ACCOUNT_NUMBER_DIGITS = "Account number must be exactly 10 digits";
	public static final String AADHAR_NUMBER_DIGITS = "Aadhar number must be exactly 12 digits";
	public static final String MOBILE_NUMBER_DIGITS = "Mobile number must be exactly 10 digits";
	
}
