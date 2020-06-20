package lab.spring.web.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)//get인지 post인지 요청 방식 설정 가능 여기서는 get방식
	public ModelAndView sayHello() {
		ModelAndView mav= new ModelAndView();
		mav.addObject("greet", getGreeting());//request.setAttribute("key,
		mav.setViewName("hello");
		return mav;
	}

public String getGreeting() {
	long now=System.currentTimeMillis();
	int Hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	String message="";
	if(Hour < 12) {
		message="Good Morning 스프링 웹~";
		
	}else if(Hour <18) {
		message="Good Afternoon 스프링 웹~";
	}else {
		message="Good Evening 스프링 웹~";
	}
	return message;
}
}
