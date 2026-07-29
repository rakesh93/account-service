package com.ilearn.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	AccountService productService;
	
	@PostMapping("/createAccount")
	public ApiResponse createProduct(@Valid @RequestBody AccountModel accountModel) {
		return productService.createAccount(accountModel);
	}
}
