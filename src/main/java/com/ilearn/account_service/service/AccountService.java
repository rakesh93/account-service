package com.ilearn.account_service.service;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ilearn.account_service.model.AccountModel;
import com.ilearn.account_service.repository.AccountRepository;
import com.ilearn.account_service.util.ApiResponse;
import com.ilearn.account_service.util.AppConstants;

@Service
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public ApiResponse createAccount(AccountModel accountModel) {
		if (accountRepository.existsByAccountNumber(accountModel.getAccountNumber())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.ACCOUNT_NUMBER_DUPLICATE,	Collections.emptyList());
		}

		if (accountRepository.existsByAadharNumber(accountModel.getAadharNumber())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.AADHAR_NUMBER_DUPLICATE, Collections.emptyList());
		}

		if (accountRepository.existsByMobileNumber(accountModel.getMobileNumber())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.MOBILE_NUMBER_DUPLICATE, Collections.emptyList());
		}

		AccountModel response = accountRepository.save(accountModel);
		if (response != null) {
			logger.info("Account created successfully with accountId {}", accountModel.getAccountId());
			return new ApiResponse(AppConstants.SUCCESS, AppConstants.CREATED, response);
		} else {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.NOT_CREATED, Collections.emptyList());
		}
	}

	public ApiResponse getAccountDetails(String accountNumber) {

		AccountModel accountModel = accountRepository.findByAccountNumber(accountNumber);

		if (accountModel == null) {
			logger.error("Account not found with accountNumber {}", accountNumber);
			return new ApiResponse(AppConstants.NOT_FOUND, AppConstants.RESULT_NOT_FOUND, Collections.emptyList());
		}
		return new ApiResponse(AppConstants.SUCCESS, AppConstants.RESULT_FOUND, accountModel);
	}

	public ApiResponse updateAccount(String accountNumber, AccountModel accountModel) {
		
		 AccountModel existingAccount = accountRepository.findByAccountNumber(accountNumber);

		if (existingAccount == null) {
			logger.error("Account not found with accountNumber {}", accountNumber);
			return new ApiResponse(AppConstants.NOT_FOUND, AppConstants.RESULT_NOT_FOUND, Collections.emptyList());
		}
		
		existingAccount.setFirstName(accountModel.getFirstName());
		existingAccount.setLastName(accountModel.getLastName());
		existingAccount.setAadharNumber(accountModel.getAadharNumber());
		existingAccount.setMobileNumber(accountModel.getMobileNumber());

		AccountModel updatedAccount = accountRepository.save(existingAccount);
		if (updatedAccount != null) {
			logger.info("Account updated successfully with accountId {}", updatedAccount.getAccountId());
			return new ApiResponse(AppConstants.SUCCESS, AppConstants.UPDATED, updatedAccount);
		} else {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.NOT_UPDATED, Collections.emptyList());
		}
	}
}
