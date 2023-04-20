package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.service.BoardService;
import com.mvc.vo.Board;

//FrontController에서 요청을 넘겨 받아 Service에게 작업을 넘김
//http://loacalhost/mvc
@Controller
public class BoardController {
	@Autowired
	BoardService service;// interface type

	//컨트롤러의 요청 처리 메소드가 리턴하는 값은 논리적 뷰 이름이다.
	// HandlerMapping(요청을 처리할 컨트롤러 결정) --> @RequestMapping로 해결
	@RequestMapping(value = {"/list", "/"}, method = RequestMethod.GET)
	public String list(Model model) {
		List<Board> list = service.selectAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping(value = "/read")
//	public String read(Model model, @RequestParam String num) {// @RequestParam 생량 가능
	public String read(Model model, String num) {//num은 requestParam의 이름과 같게해야함.
		Board b = service.selectOne(num);
		model.addAttribute("b", b);
		return "read";
	}
	
	@GetMapping(value = "/insertForm")//입력 화면 전송
	public String insertForm() { 
		return "insertForm";
	}
	
	@PostMapping(value = "/insertProcess")//사용자가 입력한 값을 받아와서 DB에 insert 작업
//	public String insertProcess(@ModelAttribute Board b) {//@ModelAttribute 생략 가능
	public String insertProcess(Board b) {//빈 Board(vo)에 채워서 파라미터를 받음, name의 속성 값과 일치하는 값만 받음
		service.insert(b);
		return "redirect:/list"; // 초기화면으로 redirect
	}
	
	@GetMapping(value = "/delete")//입력 화면 전송
	public String delete(String num) {
		service.delete(num);
		return "redirect:/list";
	}
}
