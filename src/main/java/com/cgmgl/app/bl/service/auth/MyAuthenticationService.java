package com.cgmgl.app.bl.service.auth;

import java.security.Principal;

import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.auth.AuthUser;

@Service
public interface MyAuthenticationService {
	public AuthUser getPrincipal();
}
