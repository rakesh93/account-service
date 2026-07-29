package com.ilearn.account_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilearn.account_service.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
	
	boolean existsByAccountNumber(String accountNumber);
	boolean existsByAadharNumber(String aadharNumber);
	boolean existsByMobileNumber(String mobileNumber);
	AccountModel findByAccountNumber(String accountNumber);
	
}
