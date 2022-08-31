package com.cgmgl.app.bl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.RoleDto;
import com.cgmgl.app.persistence.entity.Role;

@Service
public interface RoleService {
	public List<Role> getAllRoles();
	
	public RoleDto getRolebyId(long id);
	
	public long doCreateRole(Role role);
	
	public RoleDto getRolebyRoleName(String roleName);
	
	public boolean doesRoleExist(long id);
	
	public boolean doesRoleExist(String roleName);
}
