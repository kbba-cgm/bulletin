package com.cgmgl.app.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
		String file_path = null;

		if (userDto.getPhoto().length() > 0) {
			file_path = request.getServletContext().getRealPath("/") + "resources/images/profiles";
			if (!Files.exists(Paths.get(file_path))) {
				Files.createDirectories(Paths.get(file_path));
			}

			String fileExtension = getImageExtension(userDto.getPhoto());
			UUID fileName = UUID.randomUUID();
			file_path = Paths.get(file_path) + "/" + fileName + "." + fileExtension;
		}
		
		Role role = new Role(roleService.getRolebyRoleName("ROLE_USER"));
		userDto.setRole(role);
		userService.createUser(userDto, file_path);
		return "redirect:/";
	}

	@GetMapping("/denied")
	public String deniedPage() {
		return "denied-page";
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

}
