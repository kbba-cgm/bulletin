package com.cgmgl.app.bl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.CategoryDto;
import com.cgmgl.app.persistence.entity.Category;

@Service
public interface CategoryService {
	public List<Category> getAllCategory();

	public CategoryDto getCategoryDtoById(long id);
	
	public Category getCategoryById(long id);
	
	public boolean doesCategoryExist(long id);

	public long createCategory(CategoryDto categoryDto);

	public void updateCategory(CategoryDto categoryDto);

	public void deleteCategory(CategoryDto categoryDto);

	public void deleteCategoryById(long id);

}
