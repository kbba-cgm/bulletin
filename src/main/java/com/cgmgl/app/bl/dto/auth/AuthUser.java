package com.cgmgl.app.bl.dto.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.persistence.entity.Post;
import com.cgmgl.app.persistence.entity.Role;

public class AuthUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private UserDto userDto;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(userDto.getRole().getName()));
		return roles;
	}

	public AuthUser(UserDto userDto) {
		this.userDto = userDto;
	}

	public void updateAuthUser(UserDto userDto) {
		this.userDto = userDto;
	}

	public long getId() {
		return userDto.getId();
	}

	public void setId(long id) {
		userDto.setId(userDto.getId());
	}

	public String getEmail() {
		return userDto.getEmail();
	}

	public void setUsername(String username) {
		userDto.setName(username);
	}

	public void setEmail(String email) {
		userDto.setEmail(email);
	}

	@Override
	public String getPassword() {
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		return userDto.getName();
	}

	public List<Post> getAllPost() {
		return userDto.getPosts();
	}

	public Role getRole() {
		return userDto.getRole();
	}

	public void setRole(Role role) {
		userDto.setRole(role);
	}

	public String getPhoto() throws IOException {
		return userDto.getPhoto();
	}

	public void setPhoto(String photo) {
		userDto.setPhoto(photo);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
