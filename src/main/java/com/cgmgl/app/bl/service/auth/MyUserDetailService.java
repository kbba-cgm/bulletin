package com.cgmgl.app.bl.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.dto.auth.AuthUser;
import com.cgmgl.app.bl.service.UserService;

public class MyUserDetailService implements UserDetailsService {
	@Autowired
	UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userService.getUserByEmail(username);
		
		if(userDto == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new AuthUser(userDto);
	}

}
