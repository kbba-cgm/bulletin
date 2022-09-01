package com.cgmgl.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgmgl.app.bl.common.Common;
import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.service.RoleService;
import com.cgmgl.app.bl.service.UserService;
import com.cgmgl.app.persistence.entity.Role;

@Controller
public class AuthController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@GetMapping("/register")
	public String getRegisterForm(ModelMap m) {
		m.addAttribute("userDto", new UserDto());
		return "register";
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult br,
			HttpServletRequest request) throws Exception {
		if (br.hasErrors()) {
			return "register";
		}

		String file_path = Common.getProfileImgStorePath(userDto.getPhoto(), request);
		
		Role role = new Role(roleService.getRolebyRoleName("ROLE_USER"));
		userDto.setRole(role);
		userService.createUser(userDto, file_path);
		
		return "redirect:/";
	}

	@GetMapping("/denied")
	public String deniedPage() {
		return "denied-page";
	}
}
