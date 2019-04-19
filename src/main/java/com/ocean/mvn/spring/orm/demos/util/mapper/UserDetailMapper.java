package com.ocean.mvn.spring.orm.demos.util.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocean.mvn.spring.orm.demos.data.dto.UserDetailDTO;
import com.ocean.mvn.spring.orm.demos.data.entity.UserDetail;
import com.ocean.mvn.spring.orm.demos.data.enums.Gender;

@Component
public class UserDetailMapper extends AbstractMapper<UserDetail, UserDetailDTO> 
{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public UserDetailDTO mapToDTO(UserDetail sourceEntity, UserDetailDTO targetDTO) 
	{
		targetDTO.setId(sourceEntity.getId());
		targetDTO.setZoneId(sourceEntity.getZoneId());
		targetDTO.setFirstName(sourceEntity.getFirstName());
		targetDTO.setMiddleName(sourceEntity.getMiddleName());
		targetDTO.setLastName(sourceEntity.getLastName());
		targetDTO.setGender(sourceEntity.getGender() != null ? sourceEntity.getGender().getValue() : null);
		targetDTO.setEmail(sourceEntity.getEmail());
		targetDTO.setAddress(sourceEntity.getAddress());
		targetDTO.setZip(sourceEntity.getZip());
		//targetDTO.setUserDTO(userMapper.mapToDTO(sourceEntity.getUser(), new UserDTO()));	// It will throw StackOverflowError because of bi-directional mappings
		//UserDTO userDTO = userMapper.mapToDTOWithoutRelationship(sourceEntity.getUser(), new UserDTO());
		//userDTO.setRoleDTO(roleMapper.mapToDTO(sourceEntity.getUser().getRole(), new RoleDTO()));
		//targetDTO.setUserDTO(userDTO);
		
		return targetDTO;
	}

	@Override
	public UserDetail mapToEntity(UserDetailDTO sourceDTO, UserDetail targetEntity) 
	{
		targetEntity.setZoneId(targetEntity.getZoneId() == null ? sourceDTO.getZoneId() : targetEntity.getZoneId());
		targetEntity.setFirstName(sourceDTO.getFirstName());
		targetEntity.setMiddleName(sourceDTO.getMiddleName());
		targetEntity.setLastName(sourceDTO.getLastName());
		targetEntity.setGender(sourceDTO.getGender() != null ? Gender.getByValue(sourceDTO.getGender()) : null);
		targetEntity.setEmail(sourceDTO.getEmail());
		targetEntity.setAddress(sourceDTO.getAddress());
		targetEntity.setZip(sourceDTO.getZip());
		
		return targetEntity;
	}
}
