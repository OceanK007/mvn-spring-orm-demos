package com.ocean.mvn.spring.orm.demos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ocean.mvn.spring.orm.demos.data.dto.UserDTO;

public interface UserService 
{	
	UserDTO createUser(UserDTO userDTO, String zoneId);
	UserDTO updateUser(UserDTO userDTO, String zoneId);
	Page<UserDTO> getUserByPage(Pageable pageable);
	Page<UserDTO> getUserObjectsByPage(Pageable pageable);
	UserDTO getUserObjectById(Long userId);
	UserDTO getUserById(Long userId);
	Page<UserDTO> searchUserByPageCriteria(UserDTO userDTO, Pageable pageable);
	Page<UserDTO> searchUserByPageSpecification(UserDTO userDTO, Pageable pageable);
	Page<UserDTO> getUserBriefByPage(Pageable pageable);
}
