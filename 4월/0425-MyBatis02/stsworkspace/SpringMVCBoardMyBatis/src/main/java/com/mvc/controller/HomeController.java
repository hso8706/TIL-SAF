package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// http://localhost:port/mvc/home.bod 이런식으로 요청이 들어오면, http://localhost:port/mvc/test.bod 
//우선 1. DispatcherServlet한테 가고
//2. HandlerMapping한테 보내서 어느 컨트롤러가 일할지 결정해달라고 함 --> annotation으로 해결(@RequestMapping)

//@Controller:컨트롤러 역할의 객체
@Controller
public class HomeController {
	//Controller믜 메소드에서 리턴하는 문자열은 논리적인 뷰이름
	@RequestMapping(value = "/home.bod", method = RequestMethod.GET)
	public String home(Model model) {		
		model.addAttribute("city", "seattle" );	//key, value, model에 data 저장	
		return "home";//논리적인 뷰 이름
		// 최종뷰정보:  /WEB-INF/views/home.jsp
		// /WEB-INF/views/test/home.jsp
	}
	
	@RequestMapping(value = "/test.bod", method = RequestMethod.GET)
	public String test(Model model) {		
		model.addAttribute("city", "seoul" );		
		return "home";
	}	
}







