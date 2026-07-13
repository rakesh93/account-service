package com.ilearn.product_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilearn.product_service.model.ProductModel;
import com.ilearn.product_service.repository.ProductRepository;
import com.ilearn.product_service.util.ApiResponse;
import com.ilearn.product_service.util.AppConstants;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepository;

	public ApiResponse createProduct(ProductModel productModel) {
		if (productRepository.existsByProductName(productModel.getProductName())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.PRODUCT_NAME_DUPLICATE);
		}

		if (productRepository.existsByProductDescription(productModel.getProductDescription())) {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.PRODUCT_DESCRIPTION_DUPLICATE);
		}
		
		ProductModel response = productRepository.save(productModel);
		if (response != null) {
			logger.info("Product created successfully with productId {}", productModel.getProductId());
			return new ApiResponse(AppConstants.SUCCESS, AppConstants.CREATED);
		} else {
			return new ApiResponse(AppConstants.FAILURE, AppConstants.NOT_CREATED);
		}
	}
}
