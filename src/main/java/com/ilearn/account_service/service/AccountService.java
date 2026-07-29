package com.ilearn.account_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilearn.account_service.model.AccountModel;
import com.ilearn.account_service.repository.AccountRepository;
import com.ilearn.account_service.util.ApiResponse;
import com.ilearn.account_service.util.AppConstants;

@Service
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountRepository accountRepository;

	public ApiResponse createAccount(AccountModel accountModel) {
		if (accountRepository.existsByAccountNumber(accountModel.getAccountNumber())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.ACCOUNT_NUMBER_DUPLICATE);
		}

		if (accountRepository.existsByAadharNumber(accountModel.getAadharNumber())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.AADHAR_NUMBER_DUPLICATE);
		}
		
		if (accountRepository.existsByMobileNumber(accountModel.getMobileNumber())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.MOBILE_NUMBER_DUPLICATE);
		}
		
		AccountModel response = accountRepository.save(accountModel);
		if (response != null) {
			logger.info("Account created successfully with accountId {}", accountModel.getAccountId());
			return new ApiResponse(AppConstants.SUCCESS, AppConstants.CREATED);
		} else {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.NOT_CREATED);
		}
	}
}
