package com.ocean.mvn.spring.orm.demos.util.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocean.mvn.spring.orm.demos.data.dto.RoleDTO;
import com.ocean.mvn.spring.orm.demos.data.dto.UserDTO;
import com.ocean.mvn.spring.orm.demos.data.dto.UserDetailDTO;
import com.ocean.mvn.spring.orm.demos.data.entity.Role;
import com.ocean.mvn.spring.orm.demos.data.entity.User;
import com.ocean.mvn.spring.orm.demos.data.entity.UserDetail;
import com.ocean.mvn.spring.orm.demos.data.entity.projection.UserSummaryProjection;
import com.ocean.mvn.spring.orm.demos.data.enums.RoleType;
import com.ocean.mvn.spring.orm.demos.data.repository.RoleRepository;

@Component
public class UserMapper extends AbstractMapper<User, UserDTO> 
{
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDTO mapToDTO(User sourceEntity, UserDTO targetDTO) 
	{
		targetDTO.setId(sourceEntity.getId());
		targetDTO.setUsername(sourceEntity.getUsername());
		targetDTO.setPassword(sourceEntity.getPassword());
		targetDTO.setRoleDTO(roleMapper.mapToDTO(sourceEntity.getRole(), new RoleDTO()));
		targetDTO.setUserDetailDTO(userDetailMapper.mapToDTO(sourceEntity.getUserDetail(), new UserDetailDTO()));
		
		return targetDTO;
	}

	@Override
	public User mapToEntity(UserDTO sourceDTO, User targetEntity) 
	{
		targetEntity.setZoneId(targetEntity.getZoneId() == null ? sourceDTO.getZoneId() : targetEntity.getZoneId());
		targetEntity.setUsername(sourceDTO.getUsername());
		targetEntity.setPassword(sourceDTO.getPassword());
		
		Role role = null;
		if(sourceDTO.getRoleDTO() == null)
		{
			role = roleRepository.findByRoleType(RoleType.USER);
		}
		else
		{
			role = roleRepository.findByRoleType(RoleType.getByValue(sourceDTO.getRoleDTO().getRoleType()));
		}
		targetEntity.setRole(role);
		
		UserDetailDTO userDetailDTO = (sourceDTO.getUserDetailDTO() == null ? new UserDetailDTO() : sourceDTO.getUserDetailDTO());
		userDetailDTO.setZoneId(sourceDTO.getZoneId());
		targetEntity.setUserDetail(userDetailMapper.mapToEntity(userDetailDTO, (targetEntity.getUserDetail() == null ? new UserDetail() : targetEntity.getUserDetail())));
		
		return targetEntity;
	}
	
	public UserDTO mapToDTOWithoutRelationship(User sourceEntity, UserDTO targetDTO)
	{
		targetDTO.setId(sourceEntity.getId());
		targetDTO.setUsername(sourceEntity.getUsername());
		targetDTO.setPassword(sourceEntity.getPassword());
		return targetDTO;
	}
	
	public UserDTO mapToDTO(UserSummaryProjection sourceEntity, UserDTO targetDTO)
	{
		targetDTO.setId(sourceEntity.getUserId());
		targetDTO.setUsername(sourceEntity.getUserName());

		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRoleType(sourceEntity.getRole().getValue());
		targetDTO.setRoleDTO(roleDTO);
		
		UserDetailDTO userDetailDTO = new UserDetailDTO();
		userDetailDTO.setFirstName(sourceEntity.getFirstName());
		userDetailDTO.setLastName(sourceEntity.getLastName());
		userDetailDTO.setEmail(sourceEntity.getEmail());
		
		targetDTO.setUserDetailDTO(userDetailDTO);
		
		return targetDTO;
	}
}
