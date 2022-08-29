package com.cgmgl.app.persistence.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgmgl.app.persistence.dao.AbstractDao;
import com.cgmgl.app.persistence.dao.RoleDao;
import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

@Transactional
@Repository
public class RoleDaoImpl extends AbstractDao<Long, Role> implements RoleDao {

	public List<Role> getAllRoles() {
		return createQuery("from Role").getResultList();
	}

	public Role getRolebyId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Role getRolebyRoleName(String roleName) {
		Query query = getSession().createQuery("from Role r WHERE r.name = :rolename");
		query.setParameter("rolename", roleName);
		return (Role) query.uniqueResult();
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
