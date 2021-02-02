package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.Categories;
@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
	Categories findByCatName(String catName);
	Categories findByCatId(Integer id);
}
