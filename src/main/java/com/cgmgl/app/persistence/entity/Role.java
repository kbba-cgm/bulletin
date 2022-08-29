package com.cgmgl.app.persistence.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cgmgl.app.bl.dto.RoleDto;


@Entity(name = "Role")
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
	private String name;
	
	@OneToMany(mappedBy = "role")
	private List<User> users;
	
	@Column(name = "created_at", updatable = false)
	private Timestamp created_at;
	
	@Column(name = "updated_at")
	private Timestamp updated_at;

	public Role () {
		
	}
	
	public Role(RoleDto roleDto) {
		this.id = roleDto.getId();
		this.name = roleDto.getName();
		this.users = roleDto.getUsers();
		this.created_at = roleDto.getCreated_at();
		this.updated_at = roleDto.getUpdated_at();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
