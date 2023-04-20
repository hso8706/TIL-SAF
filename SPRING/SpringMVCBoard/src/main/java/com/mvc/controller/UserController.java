package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String loginForm() {
		return "loginForm";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
				session.removeAttribute("user");
				session.removeAttribute("admin");
				return "redirect:/list";
	}

	@PostMapping(value = "/loginProcess")
	public String loginProcess(HttpSession session, String id, String pass, String admin, RedirectAttributes ra) {
		//RedirectAttributes : redirect를 사용했음에도 불구하고 requeset 정보를 forward 마냥 전달해서 사용할 때 사용하는 객체
		//Model: Model은 요청이 응답으로 날아가면 사라짐
		
		User user = new User(id, pass);
		boolean flag = service.check(user);
		String url = "list"; //로그인 성공시 요청할 주소

		if (flag) { // 로그인 성공
			if(admin != null) { // 체크박스를 체크한 경우, null이 아님(체크박스에 value 속성 필요)
				session.setAttribute("admin", "ok");
			}
			else session.removeAttribute("admin");
			session.setAttribute("user", user);//일반 사용자면 user 객체 하나만, admin이라면 user객체 + "ok"문자열까지
		} else {// 로그인 실패
			ra.addFlashAttribute("errormsg", "ID/PW를 확인해 주세요");//FlashMemory: 일회성 속성을 지닌 메모리, 꺼내서 사용하면 사라짐
			ra.addAttribute("XYZ", "xyz"); //계속 남아있음. .jsp에서 파라미터 꺼내는 방식으로 꺼내야함
			url = "loginForm"; // 다시 로그인 화면으로 이동시킴
		}	
		
		return "redirect:/" + url;	
	}
}








