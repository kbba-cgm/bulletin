package com.cgmgl.app.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.dto.UserEditDto;
import com.cgmgl.app.bl.service.RoleService;
import com.cgmgl.app.bl.service.UserService;
import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/admin/users")
	public String allUser(ModelMap m) {
		m.addAttribute("users", userService.getAllUser());
		return "all-user";
	}
	
	@GetMapping("/admin/user/create")
	public String createUser(ModelMap m) {
		List<Role> roles = roleService.getAllRoles();
		UserDto userDto = new UserDto();
		m.addAttribute("userDto", userDto);
		m.addAttribute("roles", roles);
		return "create-user";
	}
	
	@PostMapping("/admin/user/create")
	public String storeUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult br,  Model m) throws Exception {
		
		if(br.hasErrors()) {
			List<Role> roles = roleService.getAllRoles();
			m.addAttribute("roles", roles);
			return "create-user";
		}
		userService.createUser(userDto);
		return "redirect:/admin/users";
	}
	
	@GetMapping("/admin/user/{id}/edit")
	public String editUser(@PathVariable("id") long id,ModelMap m) {		
		List<Role> roles = roleService.getAllRoles();
		UserEditDto userEditDto = new UserEditDto(userService.getUserById(id));
		m.addAttribute("userEditDto", userEditDto);
		m.addAttribute("roles", roles);
		
		return "edit-user";
	}
	
	@PostMapping("/admin/user/edit")
	public String updateUser(@Valid @ModelAttribute("userEditDto") UserEditDto userEditDto, BindingResult br, Model m) {
		if(br.hasErrors()) {
			List<Role> roles = roleService.getAllRoles();
			m.addAttribute("roles", roles);
			return "edit-user";
		}
		
		UserDto userDto = new UserDto(userEditDto);
		userService.updateUser(userDto);
		return "redirect:/admin/users";
	}
	
	@PostMapping("/admin/user/{id}/delete")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUserById(id);
		
		return "redirect:/admin/users";
	}
}
