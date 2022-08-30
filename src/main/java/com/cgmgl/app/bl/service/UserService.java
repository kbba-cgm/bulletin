package com.cgmgl.app.bl.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.UserDto;
import com.cgmgl.app.persistence.entity.User;

@Service
public interface UserService {
	public List<User> getAllUser();

	public UserDto getUserByEmail(String email);

	public UserDto getUserById(long id);

	public UserDto getUserByUsername(String username);
	
	public boolean doesUserExist(String email);

	public long createUser(UserDto userDto, String file_path) throws FileNotFoundException, IOException;

	public long createUser(UserDto userDto);

	public void updateUser(UserDto userDto);

	public void deleteUser(UserDto userDto);

	public void deleteUserById(long id);	
}
