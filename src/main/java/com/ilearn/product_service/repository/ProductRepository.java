package com.ilearn.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ilearn.product_service.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
	
	boolean existsByProductName(String productName);
	boolean existsByProductDescription(String productDescription);
	
}
