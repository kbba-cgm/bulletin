package com.cgmgl.app.bl.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.common.Common;
import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.bl.service.UserService;
import com.cgmgl.app.persistence.dao.RoleDao;
import com.cgmgl.app.persistence.dao.UserDao;
import com.cgmgl.app.persistence.entity.Role;
import com.cgmgl.app.persistence.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	private Timestamp now;

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public UserDto getUserByEmail(String email) {
		return new UserDto(userDao.getUserByEmail(email));
	}

	public UserDto getUserById(long id) {
		return new UserDto(userDao.getUserById(id));
	}

	public UserDto getUserByUsername(String username) {
		return new UserDto(userDao.getUserByUsername(username));
	}

	public boolean doesUserExist(String email) {
		return userDao.doesUserExist(email);
	}

	@Override
	public long createUser(UserDto userDto, String file_path, ServletRequest request) throws FileNotFoundException, IOException {
		now = new Timestamp(new Date().getTime());
		userDto.setCreated_at(now);
		userDto.setUpdated_at(now);

		String full_file_path = Common.getRootStoragePath(request) + file_path;
		writeImageData(userDto.getPhoto(), full_file_path);
		userDto.setPhoto(file_path);

		return userDao.createUser(getUserData(userDto));
	}

	public long createUser(UserDto userDto) {
		now = new Timestamp(new Date().getTime());
		userDto.setCreated_at(now);
		userDto.setUpdated_at(now);
		return userDao.createUser(getUserData(userDto));
	}

	public void updateUser(UserDto userDto) {
		now = new Timestamp(new Date().getTime());
		User user = userDao.getUserById(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPhoto(userDto.getPhoto());
		user.setRole(userDto.getRole());
		user.setUpdated_at(now);
		userDao.updateUser(user);
	}

	public void deleteUser(UserDto userDto) {
		userDao.deleteUser(getUserData(userDto));
	}

	public void deleteUserById(long id) {
		userDao.deleteUserById(id);
	}

	private User getUserData(UserDto userDto) {
		User user = new User();

		if (userDto.getPassword() != null)
			user.setPassword(bcryptEncoder.encode(userDto.getPassword()));

		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		user.setPosts(userDto.getPosts());
		user.setPhoto(userDto.getPhoto());
		user.setCreated_at(userDto.getCreated_at());
		user.setUpdated_at(userDto.getUpdated_at());

		return user;
	}

	public Role getUserRole(String roleName) {
		return roleDao.getRolebyRoleName(roleName);
	}

	@Override
	public void updateUser(UserDto userDto, String file_path, ServletRequest request) throws FileNotFoundException, IOException {
		User user = userDao.getUserById(userDto.getId());
		now = new Timestamp(new Date().getTime());

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		user.setUpdated_at(now);
		
		String imageBase64 = userDto.getImageString();
		String full_file_path = Common.getRootStoragePath(request) + file_path;
		writeImageData(imageBase64, full_file_path);
		user.setPhoto(file_path);
		
		userDao.updateUser(user);
	}

	private void writeImageData(String base64String, String file_path) throws FileNotFoundException, IOException {
		if (base64String == null || base64String.length() <= 0)
			return;

		String[] block = base64String.split(",");
		String realData = block[1];
		byte[] data = Base64.decodeBase64(realData);
		try (FileOutputStream stream = new FileOutputStream(file_path)) {
			stream.write(data);
		}
	}

}
