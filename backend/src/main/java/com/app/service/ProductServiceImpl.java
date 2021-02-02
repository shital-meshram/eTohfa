package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Categories;
import com.app.pojo.Products;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Products> getAllProduct() {
		return proRepo.findAll();
	}

	@Override
	public Products AddNewProducts(Products transientPOJO) {
		Products newProd =  new Products();
		newProd.setProdName(transientPOJO.getProdName());
		   newProd.setDescription(transientPOJO.getDescription());
		   newProd.setPrice(transientPOJO.getPrice());
		   newProd.setImage(transientPOJO.getImage());
		   newProd.setImageContent(transientPOJO.getImageContent());
		   newProd.setQuantity(transientPOJO.getQuantity());
		   newProd.setCategory(transientPOJO.getCategory());
		   
		  return proRepo.save(newProd);
		
	}

	@Override
	public Optional<Products> getProductsById(int id) {
		return proRepo.findById(id);
	}

	@Override
	public Products updateProductDetails(int productId, Products detachedPOJO) {
		Optional<Products>p=proRepo.findById(productId);
		if(p!=null)
		{
			Products p1=p.get();
			p1.setPrice(detachedPOJO.getPrice());
			p1.setDescription(detachedPOJO.getDescription());
			p1.setQuantity(detachedPOJO.getQuantity());
			p1.setCategory(detachedPOJO.getCategory());
			p1.setImage(detachedPOJO.getImage());
			p1.setImageContent(detachedPOJO.getImageContent());
			p1.setProdName(detachedPOJO.getProdName());
			return proRepo.save(p1);
		}
		return null;
	}

	@Override
	public String deleteProduct(int productId) {
		proRepo.deleteById(productId);
		return "Product with ID="+productId+" deleted...";
	}

	@Override
	public List<Products> getProductByCategory(Categories category) {
		
		 return proRepo.findAllByCategory(category); 
		
		
	}

//	@Override
//	public Boolean ProductImageUpload(String dtls, MultipartFile imageFile) {
//		System.out.println("data " + dtls + " " + imageFile.getOriginalFilename());
//		try {
//			Products p = new ObjectMapper().readValue(dtls, Products.class);
//			p.setImage(imageFile.getBytes());
//			p.setImageContent(imageFile.getContentType());
//			
//			proRepo.save(p);
//			return true;
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

//	@Override
//	public ResponseEntity<?> getProductByCategoryName(String name) {
//		Categories cate=catRepo.findByCatName(name); 
//	try {
//		List<Products> products= proRepo.findByCategory(cate.getCatId());
//		return new ResponseEntity<>(products, HttpStatus.OK);
//	}catch (RuntimeException e) {
//		e.printStackTrace();
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//	}
	
	
	//ADD Product Image
	

	
	
	

}
