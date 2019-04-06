package com.ocean.mvn.spring.orm.demos.data.entity.projection;

import com.ocean.mvn.spring.orm.demos.data.enums.RoleType;

public interface UserSummaryProjection
{
	Long getUserId();
	String getFirstName();
	String getLastName();
	String getUserName();
	String getEmail();
	RoleType getRole(); 
}
