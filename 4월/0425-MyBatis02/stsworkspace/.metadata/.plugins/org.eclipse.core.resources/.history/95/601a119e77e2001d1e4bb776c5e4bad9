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
	public String login() { // 로그인 화면
		return "loginForm";// view name
	}

	@PostMapping(value = "/loginProcess")
	public String login2(HttpSession session, String id, String pass, String admin, RedirectAttributes ra) throws Exception {// id, pass 받아와서 db에 가서 체크 한 후에 세션에 저장
		
			User user = new User(id, pass);
			boolean flag = service.check(user);
			String url = "list";// ok
			System.out.println(flag);
			if (flag) {// 로그인 성공
				
				if(admin != null) {
					session.setAttribute("admin", "admin");				
				}
				
				session.setAttribute("user", user);
				/* cookie 처리---------------
				if (remember != null) {// 체크박스 체크한 경우
					Cookie remem = new Cookie("remem", id);
					remem.setMaxAge(-1);
					response.addCookie(remem);

				} else {// 체크박스 푼 경우
						// 유효하지 않은 쿠키로 설정하기
					Cookie cookie = new Cookie("remem", "");
					cookie.setMaxAge(0); // 유효하지 않은 쿠키
					response.addCookie(cookie);
				}
				*/
			} else { // 로그인 실패	
				//세션을 이용하기 때문. 단, 1회용이기 때문에 redirect 되면 사라진다.전달된 Parameter는 URL에 노출되지 않는다.
				ra.addFlashAttribute("errormsg", "ID/PW를 확인해 주세요!");//바로 ${errormsg}로 꺼내서 씀.addFlashAttribute 의 경우 데이타가 post 형식으로 전달이 된다.
				//ra.addAttribute("aa", "ID/PW를 aaa 주세요!");// 데이타가 URI에 노출. param으로 전달됨 ${param.aa}. get
				url = "loginForm";
			}
		
		return "redirect:/" + url;// view name
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {// 세션에t
		session.setAttribute("user", null);
		session.setAttribute("admin", null);
		
		return "redirect:/list";// view name
	}
}


