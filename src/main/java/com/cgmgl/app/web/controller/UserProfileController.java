package com.cgmgl.app.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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
		String file_path = null;
		
		userEditDto.setRole(new Role(roleService.getRolebyRoleName("ROLE_USER")));
		
		if (userEditDto.getImageString().length() > 0) {
			file_path = request.getServletContext().getRealPath("/") + "resources/images/profiles";
			if (!Files.exists(Paths.get(file_path))) {
				Files.createDirectories(Paths.get(file_path));
			}
			System.out.println("============== here ==================");
			String fileExtension = getImageExtension(userEditDto.getImageString());
			UUID fileName = UUID.randomUUID();
			file_path = Paths.get(file_path) + "/" + fileName + "." + fileExtension;
			authUser.setPhoto(file_path);
			userService.updateUser(new UserDto(userEditDto), file_path);
			
			deleteOldImage(userEditDto.getPhoto());
		} else {
			deleteOldImage(userEditDto.getPhoto());
			userEditDto.setPhoto(null);
			userService.updateUser(new UserDto(userEditDto));
			authUser.setPhoto(userEditDto.getPhoto());
		}
		authUser.setUsername(userEditDto.getName());
		authUser.setEmail(userEditDto.getEmail());

		return "view-profile";
	}

	private String getImageExtension(String base64String) {
		String[] strings = base64String.split(",");
		String extension;
		switch (strings[0]) {// check image's extension
		case "data:image/jpeg;base64":
			extension = "jpeg";
			break;
		case "data:image/png;base64":
			extension = "png";
			break;
		case "data:image/webp;base64":
			extension = "webp";
			break;
		case "data:image/gif;base64":
			extension = "gif";
			break;
		default:
			extension = "jpg";
			break;
		}
		return extension;
	}
	
	private void deleteOldImage(String filepath) throws IOException {
		System.out.println("========== start delete ==============");
		if(filepath != null && !filepath.isEmpty()) {
			Path path = Paths.get(filepath);
			System.out.println(path);
			Files.delete(path);

			System.out.println("=========== delete ==========>>>>>");
		}
	}
}
