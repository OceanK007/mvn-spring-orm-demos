package com.ocean.mvn.spring.orm.demos.data.dto;

public class RoleDTO extends AbstractMasterDTO
{
	private String roleType;

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
}
