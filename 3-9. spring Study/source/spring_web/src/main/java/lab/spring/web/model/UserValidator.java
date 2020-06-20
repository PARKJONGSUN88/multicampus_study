package lab.spring.web.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		UserVO vo = (UserVO)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userpwd", "required");
			
	}
	
	
}
