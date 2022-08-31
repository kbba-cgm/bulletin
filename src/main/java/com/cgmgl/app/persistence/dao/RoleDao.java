package com.cgmgl.app.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgmgl.app.persistence.entity.Role;

@Repository
public interface RoleDao {
	public List<Role> getAllRoles();
	
	public Role getRolebyId(long id);
	
	public long createRole(Role role);
	
	public Role getRolebyRoleName(String roleName);
	
	public boolean doesRoleExist(long id);
	
	public boolean doesRoleExist(String roleName);
}
