package com.ilearn.product_service.util;

public class AppConstants {

	// API Response Code
	public static final int SUCCESS = 200;
	public static final int FAILURE = 400;
	public static final int NOT_FOUND = 404;
	public static final int SERVER_ERROR = 500;

	// Message Value Constant
	public static final String CREATED = "Successfully Created Product";
	public static final String NOT_CREATED = "Failure To Create Product";
	public static final String UPDATED = "Product Updated Successfully";
	public static final String NOT_UPDATED = "Failure To Update Product";
	public static final String DELETED = "Product Deleted Successfully";
	public static final String PRODUCT_NAME = "ProductName is Required";
	public static final String PRODUCT_DESCRIPTION = "Product Description is Required";
	public static final String PRODUCT_NAME_DUPLICATE = "ProductName is Duplicate";
	public static final String PRODUCT_DESCRIPTION_DUPLICATE = "Product Description is Duplicate ! Please provide a unique Product Description";
	
}
