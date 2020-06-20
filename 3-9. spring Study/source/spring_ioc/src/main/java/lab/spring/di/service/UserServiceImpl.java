package lab.spring.di.service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import lab.spring.di.persist.UserManageDAO;

@Service("loginService")
public class UserServiceImpl implements UserService, ApplicationContextAware {
	private UserManageDAO dao;
	private ApplicationContext context;

	@Autowired
	public void setDao(UserManageDAO dao) {
		this.dao = dao;		
	}
	
	@Autowired
	public void setApplicationContext(ApplicationContext context) {
		this.context = context;
	}
	
	public String[] login(String uid, String upwd) {
		String messages[] = new String[2];
		Object[] args = new String[] {uid};
		Locale locale = Locale.getDefault();
		if(dao.loginProc(uid, upwd) != null) {
			messages[0] = context.getMessage("login.success", args, locale);
		} else {
			messages[0] = context.getMessage("login.fail", args, locale);
		}
		
		Locale locale_en = Locale.ENGLISH;
		if(dao.loginProc(uid, upwd) != null) {
			messages[1] = context.getMessage("login.success", args, locale_en);
		} else {
			messages[1] = context.getMessage("login.fail", args, locale);
		}	
		return messages;
	}		


}
