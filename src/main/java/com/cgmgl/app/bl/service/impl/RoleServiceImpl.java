package com.cgmgl.app.bl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.RoleDto;
import com.cgmgl.app.bl.service.RoleService;
import com.cgmgl.app.persistence.dao.RoleDao;
import com.cgmgl.app.persistence.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	public RoleDto getRolebyId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoleDto getRolebyRoleName(String roleName) {
		return new RoleDto(roleDao.getRolebyRoleName(roleName));
	}

	public boolean doesRoleExist(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doesRoleExist(String roleName) {
		// TODO Auto-generated method stub
		return false;
	}

}
