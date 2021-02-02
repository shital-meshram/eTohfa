package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.Categories;
import com.app.pojo.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{
	Products findByProdName (String prodName);
   // List<Products> findAllByCategory(Categories catid);
    @Query("SELECT p FROM Products p WHERE p.category=:id")
    List<Products> findAllByCategory(@Param("id") Categories category);
    
}
