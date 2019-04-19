package com.ocean.mvn.spring.orm.demos.api.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocean.mvn.spring.orm.demos.data.dto.UserDTO;
import com.ocean.mvn.spring.orm.demos.service.UserService;
import com.ocean.mvn.spring.orm.demos.util.constant.ApiConstant;

@RestController
@RequestMapping(ApiConstant.USER_API)
public class UserApi 
{
	private static final Logger logger = LoggerFactory.getLogger(UserApi.class);
	/** ObjectMapper : To parse json to object | To convert object to json string | etc **/
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired	// This means to get the bean called userService, which is auto-generated by Spring
	UserService userService;
	
	/** 
		Test JSON
	 
	 	{
		    "username": "ocean1",
		    "password": "12345",
		    "userDetailDTO": 
		    {
		        "firstName": "Ocean1",
		        "middleName": null,
		        "lastName": "Life",
		        "gender": "Male",
		        "email": "OceanK007@gmail.com",
		        "address": "Chasing my bliss",
		        "zip": "110094"
		    }
		}
		
		In requestHeader: zoneId = UTC
	**/
	/** @PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST) **/
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public UserDTO createUser(@RequestBody UserDTO userDTO, @RequestHeader(value="zoneId", required=true) String zoneId) throws JsonProcessingException
	{
		userDTO = userService.createUser(userDTO, zoneId);
		logger.info("API: Creating User");
		logger.info("userDTO: "+objectMapper.writeValueAsString(userDTO));
		return userDTO;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public UserDTO updateUser(@RequestBody UserDTO userDTO, @RequestHeader(value="zoneId", required=true) String zoneId)
	{
		logger.info("API: Updating User");
		return userService.updateUser(userDTO, zoneId);
	}
	
	/** 
		@GetMapping is a shortcut for @RequestMapping(method=RequestMethod.GET)
		@GetMapping(path="/add") map only GET requests
		@RequestMapping maps all HTTP operations by default. Use @RequestMapping(method=RequestMethod.GET) or other shortcut annotations to narrow this mapping.
	**/
	/**
	 	localhost:8080/api/user/list?page=0&size=10
	 	or
	 	localhost:8080/api/user/list?page=0&size=10&sort=id,desc
	 	or
	 	localhost:8080/api/user/list?page=0&size=10&sort=userDetail.firstName,desc
	 	or
	 	localhost:8080/api/user/list					// Default values will be: pageNumber = 0, pageSize = 20, sort = null
	**/
	@RequestMapping(value="/list", method=RequestMethod.GET)
	//public Page<UserDTO> getUserByPage(@RequestParam(value="page", required=true) int page, @RequestParam(value="pageSize", required=true) int pageSize)
	public Page<UserDTO> getUserByPage(Pageable pageable)
	{
		logger.info("API: Fetching user page list");
		return userService.getUserByPage(pageable);
	}
	
	@GetMapping(path="/get")
	public UserDTO getUserById(@RequestParam("userId") Long id)
	{
		logger.info("API: Fetching user by id");
		return userService.getUserById(id);
	}
	
	@GetMapping(path="/getUserObject")
	public UserDTO getUserObjectById(@RequestParam("userId") Long id)
	{
		logger.info("API: Fetching user object by id");
		return userService.getUserObjectById(id);
	}
	
	@GetMapping(path="/getUserObjectsByPage")
	public Page<UserDTO> getUserObjectsByPage(Pageable pageable)
	{
		logger.info("API: Fetching user objects by page");
		return userService.getUserObjectsByPage(pageable);
	}
	
	/** 
	 	localhost:8080/api/user/searchUser?page=0&size=10 
		or
		localhost:8080/api/user/searchUser?page=0&size=10&sort=userDetail.firstName,desc
	**/
	/** 
	 	{
		    "username": "ocean1",
		    "userDetailDTO": 
		    {
		        "firstName": "Ocean1",
		        "lastName": "Life",
		        "email": "OceanK007@gmail.com"
		    },
		    "roleDTO": 
		    {
		        "roleType": "User"
		    }
		}
	**/
	
	@RequestMapping(value="/searchUser", method=RequestMethod.POST)
	public Page<UserDTO> searchUser(@RequestBody UserDTO userDTO, Pageable pageable)
	{
		logger.info("API: Searching user list by page");
		return userService.searchUserByPageCriteria(userDTO, pageable);
		//return userService.searchUserByPageSpecification(userDTO, pageable);
	}
	
	@RequestMapping(value="/userBriefList", method=RequestMethod.GET)
	public Page<UserDTO> getUserBrief(Pageable pageable)
	{
		logger.info("API: Searching user brief list by page");
		return userService.getUserBriefByPage(pageable);
	}
}
