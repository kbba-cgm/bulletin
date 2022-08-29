package com.cgmgl.app.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgmgl.app.bl.dto.CategoryDto;
import com.cgmgl.app.bl.service.CategoryService;
import com.cgmgl.app.persistence.entity.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("/admin/categories")
	public String allCategory(ModelMap m) {
		List<Category> categories = categoryService.getAllCategory();
		m.addAttribute("categories", categories);
		return "all-category";
	}

	@GetMapping("/admin/category/create")
	public String createCategory(ModelMap m) {
		CategoryDto categoryDto = new CategoryDto();
		m.addAttribute("categoryDto", categoryDto);
		return "create-category";
	}

	@PostMapping("/admin/category/create")
	public String createCategory(@Valid @ModelAttribute("categoryDto") CategoryDto categoryDto, BindingResult br) {
		if (br.hasErrors()) 
			return "create-category";
		
		categoryService.createCategory(categoryDto);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/category/{id}/edit")
	public String editCategory(@PathVariable("id") long id ,ModelMap m) {
		CategoryDto categoryDto = categoryService.getCategoryDtoById(id);
		m.addAttribute("categoryDto", categoryDto);
		return "edit-category";
	}
	
	@PostMapping("/admin/category/edit")
	public String updateCategory(@Valid @ModelAttribute("categoryDto") CategoryDto categoryDto, BindingResult br ) {
		if (br.hasErrors()) 
			return "edit-category";
		
		categoryService.updateCategory(categoryDto);
		return "redirect:/admin/categories";
	}
	
	@PostMapping("admin/category/{id}/delete")
	public String deleteCategory(@PathVariable("id") long id) {
		categoryService.deleteCategoryById(id);
		
		return "redirect:/admin/categories";
	}

}
