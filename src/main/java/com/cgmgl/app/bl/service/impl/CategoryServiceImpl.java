package com.cgmgl.app.bl.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.CategoryDto;
import com.cgmgl.app.bl.service.CategoryService;
import com.cgmgl.app.persistence.dao.CategoryDao;
import com.cgmgl.app.persistence.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	private Timestamp now;
	
	@Autowired
	CategoryDao categoryDao;

	public List<Category> getAllCategory() {
		return categoryDao.getAllCategory();
	}
	
	@Override
	public boolean doesCategoryExist(long id) {
		return getCategoryById(id) != null;
	}
	
	@Override
	public CategoryDto getCategoryDtoById(long id) {
		return new CategoryDto(categoryDao.getCategoryById(id));
	}

	@Override
	public Category getCategoryById(long id) {
		return categoryDao.getCategoryById(id);
	}

	public long createCategory(CategoryDto categoryDto) {
		now = new Timestamp(new Date().getTime());
		categoryDto.setCreated_at(now);
		categoryDto.setUpdated_at(now);
		return categoryDao.createCategory(getCategoryData(categoryDto));
	}

	public void updateCategory(CategoryDto categoryDto) {
		now = new Timestamp(new Date().getTime());
		categoryDto.setUpdated_at(now);
		categoryDao.updateCategory(getCategoryData(categoryDto));
	}

	public void deleteCategory(CategoryDto categoryDto) {
		categoryDao.deleteCategory(getCategoryData(categoryDto));
	}

	public void deleteCategoryById(long id) {
		categoryDao.deleteCategoryById(id);
	}
	
	private Category getCategoryData(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setPosts(categoryDto.getPosts());
		category.setCreated_at(categoryDto.getCreated_at());
		category.setUpdated_at(categoryDto.getUpdated_at());
		
		return category;
	}
	
}
