package com.cgmgl.app.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgmgl.app.bl.common.Common;
import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.dto.UserEditDto;
import com.cgmgl.app.bl.dto.auth.AuthUser;
import com.cgmgl.app.bl.service.RoleService;
import com.cgmgl.app.bl.service.UserService;
import com.cgmgl.app.bl.service.auth.MyAuthenticationService;
import com.cgmgl.app.persistence.entity.Role;

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
		UserEditDto userEditDto = new UserEditDto(
				userService.getUserById(myAuthenticationService.getPrincipal().getId()));
		m.addAttribute("userEditDto", userEditDto);
		return "edit-profile";
	}

	@PostMapping("/profile/edit")
	public String updateProfile(@Valid @ModelAttribute("userEditDto") UserEditDto userEditDto, BindingResult br,
			HttpServletRequest request) throws IOException {
		if (br.hasErrors())
			return "edit-profile";

		AuthUser authUser = myAuthenticationService.getPrincipal();
		userEditDto.setRole(new Role(roleService.getRolebyRoleName("ROLE_USER")));
		
		String file_path = Common.getProfileImgStorePath(userEditDto.getImageString(), request);
		
		if (file_path != null) {
			authUser.setPhoto(file_path);
			userService.updateUser(new UserDto(userEditDto), file_path);
			deleteOldImage(userEditDto.getPhoto());
		} else {
			authUser.setPhoto(null);
			deleteOldImage(userEditDto.getPhoto());
			userEditDto.setPhoto(null);
			userService.updateUser(new UserDto(userEditDto));
		}
		authUser.setUsername(userEditDto.getName());
		authUser.setEmail(userEditDto.getEmail());

		return "view-profile";
	}

	private void deleteOldImage(String filepath) throws IOException {
		if (filepath != null && !filepath.isEmpty()) {
			Path path = Paths.get(filepath);
			Files.delete(path);
		}
	}
}
