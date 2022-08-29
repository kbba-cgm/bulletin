package com.cgmgl.app.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgmgl.app.persistence.dao.AbstractDao;
import com.cgmgl.app.persistence.dao.CategoryDao;
import com.cgmgl.app.persistence.entity.Category;

@Transactional
@Repository
public class CategoryDaoImpl extends AbstractDao<Long, Category> implements CategoryDao {

	public List<Category> getAllCategory() {
		return createQuery("from Category").getResultList();
	}

	public Category getCategoryById(long id) {
		return getById(id);
	}

	public long createCategory(Category category) {
		return (Long) create(category);
	}

	public void updateCategory(Category category) {
		update(category);
	}

	public void deleteCategory(Category category) {
		delete(category);
	}

	public void deleteCategoryById(long id) {
		deleteById(id);
	}

}
