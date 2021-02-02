package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Categories;
import com.app.pojo.Products;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;
import com.app.service.CategoriesServiceImpl;
import com.app.service.IProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
//		@Value("${file.upload.location}")
//		private String location;
		
		@Autowired
		private ProductRepository proRep;
		@Autowired 
		private IProductService productService;
		@Autowired
		private CategoryRepository cateRepo;
		
		
		@Autowired
		private CategoriesServiceImpl cateService;
		
		
//		@PostMapping("/upload")
//		public ResponseEntity<?> UploadProductImage(@RequestParam String dtls, @RequestParam MultipartFile imageFile)
//		{
//			Boolean imagestatus = this.productService.ProductImageUpload(dtls, imageFile);
//			if(imagestatus==true)
//			{
//				return new ResponseEntity<>(HttpStatus.OK);
//			}
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
			
		@GetMapping
		@CrossOrigin(origins = "http://localhost:4200")
		public List<Products> getAllProducts()
		{
			return productService.getAllProduct();
		}	
		
		@PostMapping("/{cateId}")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> AddNewProduct(@PathVariable int cateId,@RequestBody Products newProduct)
		{
			newProduct.setCategory(cateRepo.findByCatId(cateId));
			 try {
					Products newProd = proRep.save(newProduct);
					return new ResponseEntity<Products>(newProd, HttpStatus.OK);
				}
				catch (RuntimeException e) {
			      e.printStackTrace();
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		
		
		@PutMapping("/{productId}")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> updatePProduct(@PathVariable int productId,@RequestBody Products existingProduct)
		{
			   try {
				   Products updateDetails=productService.updateProductDetails(productId, existingProduct);
				   return new ResponseEntity<>(updateDetails, HttpStatus.OK);
			   }
			   catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
		}
		
//		@GetMapping("/category/CateName/{cateName}")
//		public List<Products> getProductBycategory(@PathVariable String cateName)
//		
//		{   Categories cat=cateRepo.findByCatName(cateName);         
//			//return proRep.findAll(cat.getCatId());
//			 return (List<Products>) productService.getProductByCateName(cateName);
//			 
//		}
		
		@DeleteMapping("/delete/{productId}")
		public String deleteProduct(@PathVariable int productId)
		{
			System.out.println("in del product "+productId);
	        return productService.deleteProduct(productId);
		}
		
		@GetMapping("/{productId}")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> getProductById(@PathVariable int productId)
		{
			  Optional<Products> product =productService.getProductsById(productId);
			  if(product.isPresent())
				  return new ResponseEntity<>(product,HttpStatus.OK);
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		@GetMapping("/category/{catId}")
		@CrossOrigin(origins = "http://localhost:4200")
	    public List<Products> getAllProductssByCateId(@PathVariable (value = "catId") Categories catId) {
	        return proRep.findAllByCategory(catId);
	    }


		@PostMapping("/getProductByCategory")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?>getProductByCategory(@RequestBody Categories category){
			List<Products>productList= productService.getProductByCategory(category);
			
			if(productList!=null)
			{
				return new ResponseEntity<>(productList, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
		//**************categories***************************
		
		@GetMapping("/categories")
		@CrossOrigin(origins = "http://localhost:4200")
		public List<Categories> getListCategories()
		{
			return cateService.getAllCategories();
		}
		
		@PostMapping("/categories")
		@CrossOrigin(origins = "http://localhost:4200")
		public Categories AddNewCategories(@RequestBody Categories newCategories)
		{
			 
				return cateService.addNewCategories(newCategories);
		}
		
		@PutMapping("/categories/update/{id}")
		public ResponseEntity<?> UpdateCategories(@PathVariable int id,@RequestBody Categories newCategories)
		{
			 try {
				Categories newCate= cateService.updateCategories(id,newCategories);
				return new ResponseEntity<Categories>(newCate, HttpStatus.OK);
				}
				catch (RuntimeException e) {
			      e.printStackTrace();
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
		      }
		
		@GetMapping("/categories/name/{catName}")
		public ResponseEntity<?> getCategoriesByName(@PathVariable String catName)
		{
			try
			{
				Categories cat=cateService.findByCatName(catName);
				return new ResponseEntity<Categories>(cat, HttpStatus.OK);
			}
			catch (RuntimeException e) {
			      e.printStackTrace();
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
		}
		
		@GetMapping("/categories/{catId}")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> getCategoriesById(@PathVariable Integer catId)
		{
			try
			{
				Categories cat=cateRepo.findByCatId(catId);
				return new ResponseEntity<Categories>(cat, HttpStatus.OK);
			}
			catch (RuntimeException e) {
			      e.printStackTrace();
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
		}
		
		@DeleteMapping("/categories/delete/{catId}")
		public String deleteCategory(@PathVariable int catId)
		{
			System.out.println("in del Category "+catId);
	        return cateService.deleteCategories(catId);
		}
		
		@DeleteMapping("/categories/deleteAll")
		public void deleteAllCategories()
		{
	         cateRepo.deleteAll();
		}
	
}
