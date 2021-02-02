package com.app.service;



import java.util.List;
import java.util.Optional;

import com.app.pojo.Categories;

public interface ICategoriesService   {
	Categories findByCatName(String catName);
    Categories addNewCategories(Categories c);
    //Categories findCategory(int id);
    List<Categories> getAllCategories();
    Categories updateCategories(int id,Categories detachedCate);
    String deleteCategories(int catId);
	
     
}
