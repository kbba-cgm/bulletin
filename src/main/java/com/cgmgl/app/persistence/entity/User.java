package com.cgmgl.app.persistence.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.cgmgl.app.bl.dto.UserDto;

@Entity(name = "User")
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	@Email
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Post> posts;

	@ManyToOne
	private Role role;
	
	@Column(name = "photo")
	private String photo;

	@Column(name = "created_at", updatable = false)
	private Timestamp created_at;

	@Column(name = "updated_at")
	private Timestamp updated_at;

	public User() {

	}

	public User(UserDto userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.email = userDto.getEmail();
		this.password = userDto.getPassword();
		this.posts = userDto.getPosts();
		this.role = userDto.getRole();
		this.photo = userDto.getPhoto();
		this.created_at = userDto.getCreated_at();
		this.updated_at = userDto.getUpdated_at();
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

}
