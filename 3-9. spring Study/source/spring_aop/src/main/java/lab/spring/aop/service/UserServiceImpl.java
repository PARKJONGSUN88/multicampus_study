package lab.spring.aop.service;



import java.util.List;

import org.springframework.beans.BeansException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.stereotype.Service;

import lab.spring.aop.persist.UserManageDAO;
import lab.spring.aop.persist.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserManageDAO dao;
	private ApplicationContext context;
	
	public void setDao(UserManageDAO dao) {
		this.dao = dao;		
	}	
	
	public int registMember(UserVO vo) {
		int result = 0;
		result = dao.joinProc(vo);			
		return result;
	}

	public int updateUser(UserVO user) {	
		return dao.updateUser(user);
	}

	public int removeUser(String uid) {
		return dao.removeUser(uid);
	}

	public UserVO findUser(String uid) {		
		return dao.findUser(uid);
	}
	
	public List<UserVO> login(String uid, String upwd) {	
		return dao.loginProc(uid, upwd);
	}

	public List<UserVO> findUserList() {	
		return dao.findUserList();
	}		


}
