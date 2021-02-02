package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Categories;
import com.app.pojo.Products;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoriesServiceImpl implements ICategoriesService {
	
	@Autowired
	private CategoryRepository cat;

	@Override
	public Categories findByCatName(String catName) {
		
		return cat.findByCatName(catName);
	}
	
	@Override
	public Categories addNewCategories(Categories c) {
		    Categories cate=new Categories();
		    cate.setCatName(c.getCatName());
		    cate.setBrand(c.getBrand());
		return cat.save(cate);
	}
	@Override
	public List<Categories> getAllCategories() {
		
		return cat.findAll();
	}
	@Override
	public Categories updateCategories(int id,Categories detachedCate) {
		Optional<Categories> c=Optional.of(cat.findByCatId(id));
		if(c!=null)
		{
			Categories c1=c.get();
			c1.setCatName(detachedCate.getCatName());
			c1.setBrand(detachedCate.getBrand());
			return c1;
		}
		return null;
	
	}
	@Override
	public String deleteCategories(int catId) {
		cat.deleteById(catId);
		return "Category with ID="+catId+" deleted...";
	}
	
	
	

}
