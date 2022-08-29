package com.cgmgl.app.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.dto.UserEditDto;
import com.cgmgl.app.bl.dto.auth.AuthUser;
import com.cgmgl.app.bl.service.RoleService;
import com.cgmgl.app.bl.service.UserService;
import com.cgmgl.app.bl.service.auth.MyAuthenticationService;
import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

@Controller
public class UserProfileController {
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	MyAuthenticationService myAuthenticationService;
	
	@GetMapping("/profile/detail")
	public String showProfile() {
		return "view-profile";
	}
	
	@GetMapping("/profile/edit")
	public String editProfile(Model m) {
		UserEditDto userEditDto = new UserEditDto(userService.getUserById(myAuthenticationService.getPrincipal().getId()));
		m.addAttribute("userEditDto", userEditDto);
		return "edit-profile";
	}
	
	@PostMapping("/profile/edit")
	public String updateProfile(@Valid @ModelAttribute("userEditDto") UserEditDto userEditDto, BindingResult br) {
		if(br.hasErrors())
			return "edit-profile";
		
		userEditDto.setRole(new Role(roleService.getRolebyRoleName("ROLE_USER")));
		userService.updateUser(new UserDto(userEditDto));
		
		AuthUser authUser = myAuthenticationService.getPrincipal();
		authUser.setUsername(userEditDto.getName());
		authUser.setEmail(userEditDto.getEmail());
		
		return "view-profile";
	}
}
