package lab.spring.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.SearchVO;
import lab.spring.web.model.UserVO;
import lab.spring.web.model.UserValidator;
import lab.spring.web.service.UserService;

@RestController
public class UserManageController {	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String form() {
		return "user_form";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") UserVO vo,
									BindingResult rs) {		
		ModelAndView mav = new ModelAndView();
		new UserValidator().validate(vo, rs);
		if(rs.hasErrors()) {
			mav.setViewName("user_form");
		}else if(service.addUser(vo) > 0) {			
			mav.setViewName("redirect:/list.do");			
		}else{
			mav.setViewName("redirect:/login.do");			
		}
		return mav;
	}
	
	@ModelAttribute("searchConditionList")
	public ArrayList<SearchVO> makeSearchConditionList(){
		ArrayList<SearchVO> searchConditionList = new ArrayList<SearchVO>();
		searchConditionList.add(new SearchVO("userid", "아이디"));
		searchConditionList.add(new SearchVO("username", "이름"));
		searchConditionList.add(new SearchVO("email", "이메일"));
		return searchConditionList;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView listUser(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<UserVO> userList = null;
		//if(session.getAttribute("authInfo")!=null) {
			userList = service.findUserList();
			mav.addObject("users", userList);
			mav.setViewName("user_list");
//		}else {
//			mav.setViewName("redirect:/login.do");
//		}			
		return mav;
	}	
		
	@RequestMapping("/update.do")
	public ModelAndView updateUser(UserVO user) {		
		ModelAndView mav = new ModelAndView();		
		if(service.updateUser(user) > 0) {			
			mav.setViewName("redirect:/list.do");			
		}else{
			mav.setViewName("redirect:/login.do");			
		}
		return mav;
	}
	
	@RequestMapping("/remove.do")
	public ModelAndView dropUser(@RequestParam("userid")String userid) {		
		ModelAndView mav = new ModelAndView();		
		if(service.removeUser(userid) > 0) {			
			mav.setViewName("redirect:/list.do");			
		}else{
			mav.setViewName("redirect:/login.do");			
		}
		return mav;
	}	
	
	@RequestMapping("/view.do")
	public ModelAndView modifyUser(@RequestParam("userid")String uid) {		
		ModelAndView mav = new ModelAndView();		
		UserVO vo = null;		
		vo = service.findUser(uid);
		mav.addObject("user", vo);
		mav.setViewName("user_modify");
		return mav;
	}
	
	@RequestMapping(value="/search.do",method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("searchCondition")String condition, 
								@RequestParam("searchKeyword")String keyword) {
			ModelAndView mav = new ModelAndView();
			List<UserVO> userList = null;
			userList = service.findUser(condition, keyword);
			//System.out.println(userList.size());
			mav.addObject("users", userList);
			mav.setViewName("user_list");
			return mav;
	}
	
	@RequestMapping("/listJson.do")
	public ArrayList<UserVO> listUser() {
		ArrayList<UserVO> userList = null;		
			userList = (ArrayList)service.findUserList();		
		return userList;
	}	
	
	
}
