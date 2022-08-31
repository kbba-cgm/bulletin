package com.cgmgl.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cgmgl.app.persistence.dao.RoleDao;
import com.cgmgl.app.persistence.dao.UserDao;
import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

@Configuration
public class DatabaseSeeder {
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;
	
	@EventListener
	public void seedRoles(ContextRefreshedEvent event) {
		seedRolesTable();
		seedUsersTable();
	}

	private void seedRolesTable() {
		Role admin = new Role("ROLE_ADMIN");
		Role user = new Role("ROLE_USER");

		if (roleDao.getRolebyRoleName("ROLE_ADMIN") == null) {
			roleDao.createRole(admin);
		}
		if (roleDao.getRolebyRoleName("ROLE_USER") == null) {
			roleDao.createRole(user);
		}
	}
	
	private void seedUsersTable() {
		User user1 = new User();
		user1.setName("Kyaw Bo Bo Aung");
		user1.setEmail("kbba@gmail.com");
		user1.setPassword(bcryptEncoder.encode("password"));
		user1.setRole(roleDao.getRolebyRoleName("ROLE_ADMIN"));
		
		User user2 = new User();
		user2.setName("Testing User");
		user2.setEmail("testinguser@gmail.com");
		user2.setPassword(bcryptEncoder.encode("password"));
		user2.setRole(roleDao.getRolebyRoleName("ROLE_USER"));
		
		if(userDao.getUserByEmail("kbba@gmail.com") == null) {
			userDao.createUser(user1);
		}
		if(userDao.getUserByEmail("testinguser@gmail.com") == null) {
			userDao.createUser(user2);
		}
	}

}
