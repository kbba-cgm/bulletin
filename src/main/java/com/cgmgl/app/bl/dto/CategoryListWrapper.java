package com.cgmgl.app.bl.dto;

import java.util.ArrayList;
import java.util.List;

import com.cgmgl.app.persistence.entity.Category;

public class CategoryListWrapper {
	private List<Category> category_lists;
	
	public CategoryListWrapper() {
		this.category_lists = new ArrayList<Category>();
	}

	public List<Category> getCategory_lists() {
		return category_lists;
	}

	public void setCategory_lists(List<Category> category_lists) {
		this.category_lists = category_lists;
	}
	
	public void add(Category category) {
		category_lists.add(category);
	}

	@Override
	public String toString() {
		return "CategoryListWrapper [category_lists=" + category_lists + "]";
	}
	
}
