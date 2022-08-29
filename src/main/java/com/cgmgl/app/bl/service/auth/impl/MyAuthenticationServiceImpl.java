package com.cgmgl.app.bl.service.auth.impl;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.auth.AuthUser;
import com.cgmgl.app.bl.service.auth.MyAuthenticationService;

@Service
public class MyAuthenticationServiceImpl implements MyAuthenticationService {
	
	@Override
	public AuthUser getPrincipal() {
		return (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
