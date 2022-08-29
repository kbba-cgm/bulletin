package com.cgmgl.app.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgmgl.app.persistence.entity.User;

@Repository
public interface UserDao {
	public List<User> getAllUser();

	public User getUserByEmail(String email);

	public User getUserById(long id);

	public User getUserByUsername(String username);
	
	public boolean doesUserExist(String email);

	public long createUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public void deleteUserById(long id);	
}
