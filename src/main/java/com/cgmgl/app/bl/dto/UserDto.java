package com.cgmgl.app.bl.dto;

import java.sql.Timestamp;
import java.util.List; 
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cgmgl.app.persistence.entity.Post;
import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

public class UserDto {	
	private long id;

	@NotEmpty
	private String name;

	@NotEmpty(message = "Email must not be empty")
	@Email
	private String email;

	@NotEmpty(message = "Password must not be empty.")
	private String password;

	private List<Post> posts;
	
	private Role role;
	
	private String photo;
	
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public UserDto() {

	}
	
	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.posts = user.getPosts();
		this.role = user.getRole();
		this.photo = user.getPhoto();
		this.created_at = user.getCreated_at();
		this.updated_at = user.getUpdated_at();
	}
	
	public UserDto(UserEditDto userEditDto) {
		this.id = userEditDto.getId();
		this.name = userEditDto.getName();
		this.email = userEditDto.getEmail();
		this.role = userEditDto.getRole();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", posts="
				+ posts + ", role=" + role + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}

}
