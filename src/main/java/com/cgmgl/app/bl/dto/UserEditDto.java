package com.cgmgl.app.bl.dto;
 
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cgmgl.app.persistence.entity.Role;

public class UserEditDto {	
	private long id;

	@NotEmpty(message = "Name must not be empty")
	private String name;

	@NotEmpty(message = "Email must not be empty")
	@Email
	private String email;
	
	@Valid
	private Role role;
	
	private String photo;
	
	public UserEditDto() {

	}
	
	public UserEditDto(UserDto userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.email = userDto.getEmail();
		this.role = userDto.getRole();
		this.photo = userDto.getPhoto();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
