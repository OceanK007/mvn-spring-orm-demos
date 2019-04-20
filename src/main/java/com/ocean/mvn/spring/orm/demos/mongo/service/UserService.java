package com.ocean.mvn.spring.orm.demos.mongo.service;

import java.util.List;

import com.ocean.mvn.spring.orm.demos.data.dto.UserDTO;

public interface UserService 
{	
	List<UserDTO> getUserList();
	UserDTO findByUsername(String username);
	List<UserDTO> findByAddress(String address);
	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO);
	void deleteUserById(String userMongoId);
}