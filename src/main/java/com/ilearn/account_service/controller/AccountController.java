package com.ilearn.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilearn.account_service.model.AccountModel;
import com.ilearn.account_service.service.AccountService;
import com.ilearn.account_service.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/accountservice")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public ApiResponse createProduct(@Valid @RequestBody AccountModel accountModel) {
		return accountService.createAccount(accountModel);
	}
	
	@GetMapping("/getAccount/{accountNumber}")
	public ApiResponse getAccount(@PathVariable String accountNumber) {
		return accountService.getAccountDetails(accountNumber);
	}
	
	@PutMapping("/updateAccount/{accountNumber}")
	public ApiResponse updateAccount(@PathVariable String accountNumber, @Valid @RequestBody AccountModel accountModel) {
		return accountService.updateAccount(accountNumber, accountModel);
	}
	
	@DeleteMapping("/deleteAccount/{accountNumber}")
	public ApiResponse deleteAccount(@PathVariable String accountNumber) {
		return accountService.deleteAccount(accountNumber);
	}
	
	@PatchMapping("/activeOrDeactiveAccount/{accountNumber}/{status}")
	public ApiResponse activateOrDeactiveAccount(@PathVariable String accountNumber, @PathVariable boolean status) {
		return accountService.activateOrDeactiveAccount(accountNumber,status);
	}
}
