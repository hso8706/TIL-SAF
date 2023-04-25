package com.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.service.UserService;
import com.mvc.vo.User;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping(value = "/loginForm")
	public String login() { // 濡쒓렇�씤 �솕硫�
		return "loginForm";// view name
	}

	@PostMapping(value = "/loginProcess")
	public String login2(HttpSession session, String id, String pass, String admin, RedirectAttributes ra) throws Exception {// id, pass 諛쏆븘���꽌 db�뿉 媛��꽌 泥댄겕 �븳 �썑�뿉 �꽭�뀡�뿉 ���옣
		
			User user = new User(id, pass);
			boolean flag = service.check(user);
			String url = "list";// ok
			System.out.println(flag);
			if (flag) {
				
				if(admin != null) {
					session.setAttribute("admin", "admin");				
				}
				
				session.setAttribute("user", user);
			} else {
				
				ra.addFlashAttribute("errormsg", "ID/PW를 확인해주세요!");
				url = "loginForm";
			}
		
		return "redirect:/" + url;// view name
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {// �꽭�뀡�뿉t
		session.setAttribute("user", null);
		session.setAttribute("admin", null);
		
		return "redirect:/list";// view name
	}
}


