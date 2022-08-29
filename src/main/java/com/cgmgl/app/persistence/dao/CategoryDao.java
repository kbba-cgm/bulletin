package com.cgmgl.app.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgmgl.app.persistence.entity.Category;

@Repository
public interface CategoryDao {
	public List<Category> getAllCategory();

	public Category getCategoryById(long id);

	public long createCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category category);

	public void deleteCategoryById(long id);
}
