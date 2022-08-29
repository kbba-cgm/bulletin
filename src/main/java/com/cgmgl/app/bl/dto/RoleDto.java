package com.cgmgl.app.bl.dto;

import java.sql.Timestamp;
import java.util.List;

import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

public class RoleDto {
	private long id;
	
	private String name;
	
	private List<User> users;
	
	private Timestamp created_at;
	
	private Timestamp updated_at;
	
	public RoleDto() {
		
	}
	
	public RoleDto(Role role) {
		this.id = role.getId();
		this.name = role.getName();
		this.users = role.getUsers();
		this.created_at = role.getCreated_at();
		this.updated_at = role.getUpdated_at();
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
