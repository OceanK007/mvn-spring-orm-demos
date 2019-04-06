package com.ocean.mvn.spring.orm.demos.util.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ocean.mvn.spring.orm.demos.data.dto.UserDetailDTO;

@Component
public class UserDetailValidator extends AbstractMasterValidator<UserDetailDTO>
{
	@Override
	public Map<String, String> validate(UserDetailDTO sourceDTO)
	{
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		return validationErrors;
	}
}
