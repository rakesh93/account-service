package com.ilearn.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilearn.product_service.model.ProductModel;
import com.ilearn.product_service.service.ProductService;
import com.ilearn.product_service.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/productservice")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/createProduct")
	public ApiResponse createProduct(@Valid @RequestBody ProductModel productModel) {
		return productService.createProduct(productModel);
	}
}
