package com.ilearn.product_service.model;

import com.ilearn.product_service.util.AppConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "productdetail",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "product_name"),
    @UniqueConstraint(columnNames = "product_description")
})
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column(name = "product_name")
	@NotBlank(message = AppConstants.PRODUCT_NAME)
	private String productName;
	@Column(name = "product_description")
	@NotBlank(message = AppConstants.PRODUCT_DESCRIPTION)
	private String productDescription;
	@Column(name = "product_price")
	private Double productPrice;
	@Column(name = "product_quantity")
	private Integer productQuantity;
	@Column(name = "product_category_id")
	private int productCategoryId;
	

	public ProductModel() {
	}

	public ProductModel(Long productId, String productName, String productDescription, Double productPrice,
			Integer productQuantity, int productCategoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productCategoryId = productCategoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", productCategoryId=" + productCategoryId + "]";
	}

}
