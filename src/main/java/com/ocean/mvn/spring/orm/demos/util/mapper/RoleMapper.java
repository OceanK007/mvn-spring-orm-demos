package com.ocean.mvn.spring.orm.demos.util.mapper;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

import com.ocean.mvn.spring.orm.demos.data.dto.RoleDTO;
import com.ocean.mvn.spring.orm.demos.data.entity.Role;
import com.ocean.mvn.spring.orm.demos.data.enums.RoleType;

@Component
public class RoleMapper extends AbstractMapper<Role, RoleDTO> 
{
	@Override
	public RoleDTO mapToDTO(Role sourceEntity, RoleDTO targetDTO) 
	{
		targetDTO.setId(sourceEntity.getId());
		targetDTO.setRoleType(sourceEntity.getRoleType().getValue());
		
		return targetDTO;
	}

	@Override
	public Role mapToEntity(RoleDTO sourceDTO, Role targetEntity) 
	{
		targetEntity.setId(sourceDTO.getId());
		targetEntity.setRoleType((sourceDTO.getRoleType() == null) ? RoleType.USER :  RoleType.getByValue(sourceDTO.getRoleType()));
		targetEntity.setDateCreated((sourceDTO.getDateCreated() == null) ? null : new DateTime(sourceDTO.getDateCreated(), DateTimeZone.UTC));

		return targetEntity;
	}
}
