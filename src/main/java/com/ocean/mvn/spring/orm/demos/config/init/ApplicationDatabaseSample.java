package com.ocean.mvn.spring.orm.demos.config.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocean.mvn.spring.orm.demos.data.entity.Role;
import com.ocean.mvn.spring.orm.demos.data.enums.RoleType;
import com.ocean.mvn.spring.orm.demos.data.repository.RoleRepository;

@Component
public class ApplicationDatabaseSample 
{
	@Autowired
	private RoleRepository roleRepository;
	
	void createRoleData()
	{
		if(roleRepository.count() != 0)
			return ;
		
		Role admin = new Role();
		admin.setRoleType(RoleType.ADMIN);
		
		Role user = new Role();
		user.setRoleType(RoleType.USER);
		
		Role editor = new Role();
		editor.setRoleType(RoleType.EDITOR);
		
		roleRepository.save(admin);
		roleRepository.save(user);
		roleRepository.save(editor);
	}
}
