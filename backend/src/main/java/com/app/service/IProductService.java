package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Categories;
import com.app.pojo.Products;

public interface IProductService {

	List<Products> getAllProduct();
	//Products AddNewProducts(Products transientPOJO);
	Optional<Products> getProductsById(int id);
	Products updateProductDetails(int productId, Products detachedPOJO);
	String deleteProduct(int productId);
	Products AddNewProducts( Products transientPOJO);
	//ResponseEntity<?> getProductByCategoryName(String name);
	List<Products> getProductByCategory(Categories category);
	//Boolean ProductImageUpload(String dtls, MultipartFile imageFile);
}
