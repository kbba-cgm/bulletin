package com.cgmgl.app.persistence.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgmgl.app.persistence.dao.AbstractDao;
import com.cgmgl.app.persistence.dao.UserDao;
import com.cgmgl.app.persistence.entity.User;

@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	public List<User> getAllUser() {
		return createQuery("from User").getResultList();
	}

	@SuppressWarnings("rawtypes")
	public User getUserByEmail(String email) {
		Query query = getSession().createQuery("FROM User u WHERE u.email = :email");
		query.setParameter("email", email);
		return (User) query.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	public User getUserById(long id) {
		Query query = getSession().createQuery("FROM User u WHERE u.id = :id");
		query.setParameter("id", id);
		return (User) query.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	public User getUserByUsername(String username) {
		Query query = getSession().createQuery("FROM User u WHERE u.name = :username");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}

	public boolean doesUserExist(String email) {
		return getUserByEmail(email) != null;
	}

	public long createUser(User user) {
		return (Long) create(user);
	}

	public void updateUser(User user) {
		update(user);
	}

	public void deleteUser(User user) {
		delete(user);
	}

	public void deleteUserById(long id) {
		deleteById(id);
	}

}
