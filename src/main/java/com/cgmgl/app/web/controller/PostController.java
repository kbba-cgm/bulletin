package com.cgmgl.app.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgmgl.app.bl.dto.PostDto;
import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.service.CategoryService;
import com.cgmgl.app.bl.service.PostService;
import com.cgmgl.app.bl.service.UserService;
import com.cgmgl.app.bl.service.auth.MyAuthenticationService;
import com.cgmgl.app.persistence.entity.Category;
import com.cgmgl.app.persistence.entity.Post;
import com.cgmgl.app.persistence.entity.User;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MyAuthenticationService myAuthenticationService;

	@GetMapping("/")
	public String home(ModelMap m) {
		List<PostDto> posts = postService.getPublicPost();
		m.addAttribute("posts", posts);

		return "home";
	}

	@GetMapping("/post/all")
	public String allPosts(ModelMap m) {
		List<Post> ownPosts = postService.getOwnPost(myAuthenticationService.getPrincipal().getId());
		User LoggedInUser = new User(userService.getUserById(myAuthenticationService.getPrincipal().getId()));
		m.addAttribute("posts", LoggedInUser.getPosts());

		return "all-post";
	}

	@GetMapping("/post/create")
	public String createPost(ModelMap m) {
		PostDto postDto = new PostDto();
		m.addAttribute("postDto", postDto);
		m.addAttribute("categories", categoryService.getAllCategory());
		
		return "create-post";
	}

	@PostMapping("/post/create")
	public String storePost(@Valid @ModelAttribute("postDto") PostDto postDto, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("categories", categoryService.getAllCategory());
			return "create-post";
		}
		
		LongStream categories_stream = Arrays.stream(postDto.getCategories_id());
		List<Category> category_list = categories_stream.mapToObj(id -> categoryService.getCategoryById(id)).toList();
		postDto.setCategories(category_list);
		UserDto LoggedInUser = userService.getUserById(myAuthenticationService.getPrincipal().getId());
		postDto.setUserDto(LoggedInUser);
		@SuppressWarnings("unused")
		Long id = postService.createPost(postDto);
		
		return "redirect:/";

	}

	@GetMapping("/post/{id}")
	public String showPost(@PathVariable("id") long id, ModelMap m) {
		PostDto postDto = postService.getPostById(id);
		m.addAttribute("postDto", postDto);
		return "detail-post";
	}

	@GetMapping("/post/{id}/edit")
	public String editPost(@PathVariable("id") long id, ModelMap m) {
		PostDto postDto = postService.getPostById(id);
		int size = postDto.getCategories().size();
		long[] ids = new long[size];
		int i = 0;
		
		for (Category cat : postDto.getCategories()) {
			ids[i++] = cat.getId();
		}
		postDto.setCategories_id(ids);
		
		m.addAttribute("categories", categoryService.getAllCategory());
		m.addAttribute("postDto", postDto);
		
		return "edit-post";
	}

	@PostMapping("/post/edit")
	public String editPost(@Valid @ModelAttribute("postDto") PostDto postDto, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("categories", categoryService.getAllCategory());
			return "create-post";
		}
		
		LongStream categories_stream = Arrays.stream(postDto.getCategories_id());
		List<Category> category_list = categories_stream.mapToObj(id -> categoryService.getCategoryById(id)).toList();
		postDto.setCategories(category_list);
		UserDto LoggedInUser = userService.getUserById(myAuthenticationService.getPrincipal().getId());
		postDto.setUserDto(LoggedInUser);
		
		postService.updatePost(postDto);
		
		return "redirect:/post/all";
	}
	
	@PostMapping("/post/{id}/delete")
	public String deletePost(@PathVariable("id") long id) {
		postService.deletePostById(id);
		return "redirect:/post/all";
	}

}
