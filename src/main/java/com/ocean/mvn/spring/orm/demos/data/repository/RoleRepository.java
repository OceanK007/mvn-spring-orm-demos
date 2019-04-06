package com.ocean.mvn.spring.orm.demos.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocean.mvn.spring.orm.demos.data.entity.Role;
import com.ocean.mvn.spring.orm.demos.data.enums.RoleType;

/** 
	Repository Interface 
			^
	CrudRepository Interface
			^
	PagingAndSortingRepository Interface
			^
	JpaRepository Interface
**/

public interface RoleRepository extends JpaRepository<Role, Long>  
{
	Role findByRoleType(RoleType roleType);
}
