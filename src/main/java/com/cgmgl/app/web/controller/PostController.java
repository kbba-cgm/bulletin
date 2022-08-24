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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgmgl.app.bl.dto.PostDto;
import com.cgmgl.app.bl.service.PostService;
import com.cgmgl.app.persistence.entity.Post;

@Controller
public class PostController {
	@Autowired
	PostService postService;

	@GetMapping("/")
	public String home(ModelMap m) {
		List<Post> posts = postService.getPublicPost();
		m.addAttribute("posts", posts);

		return "home";
	}

	@GetMapping("/post/all")
	public String allPosts(ModelMap m) {
		List<Post> ownPosts = postService.getOwnPost();
		if (!ownPosts.isEmpty())
			m.addAttribute("posts", ownPosts);

		return "all-post";
	}

	@GetMapping("/post/create")
	public String createPost(ModelMap m) {
		PostDto postDto = new PostDto();
		m.addAttribute("postDto", postDto);
		return "create-post";
	}

	@PostMapping("/post/create")
	public String storePost(@Valid @ModelAttribute("postDto") PostDto postDto, BindingResult br) {
		if (br.hasErrors()) {
			return "create-post";
		} else {
			Long id = postService.createPost(postDto);
			return "redirect:/";
		}
	}

	@GetMapping("/post/{id}")
	public String showPost(@PathVariable("id") long id, ModelMap m) {
		PostDto postDto = postService.getPostById(id);
		m.addAttribute("postDto", postDto);
		return "detail-post";
	}

	@GetMapping("/post/{id}/edit")
	public String editPost(@PathVariable("id") long id, ModelMap m) {
		System.out.println(id);
		PostDto postDto = postService.getPostById(id);
		m.addAttribute("postDto", postDto);
		return "edit-post";
	}

	@PostMapping("/post/edit")
	public String editPost(@Valid @ModelAttribute("postDto") PostDto postDto, BindingResult br) {
		postService.updatePost(postDto);
		return "redirect:/post/all";
	}
	
	@PostMapping("/post/{id}/delete")
	public String deletePost(@PathVariable("id") long id) {
		postService.deletePostById(id);
		return "redirect:/post/all";
	}
}
