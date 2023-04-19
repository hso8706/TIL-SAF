package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//localhost:8080/test/
@Controller
public class HomeController {
	
	//controller의 메소드에서 리턴하는 문자열은 무조건 논리적인 뷰이름
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//data
		model.addAttribute("code", "1234");
		model.addAttribute("name", "kim");
		model.addAttribute("address", "seoul");
		
		return "home";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		//data
		model.addAttribute("greeting", "hi!");
		
		return "hello";
	}
	
}
