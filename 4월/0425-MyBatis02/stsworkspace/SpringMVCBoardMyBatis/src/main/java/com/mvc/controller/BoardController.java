package com.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.service.BoardService;
import com.mvc.vo.Board;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = { "/list","/" }, method = RequestMethod.GET)
	public String selectAll(Model model)throws Exception {// Map(key, value)
//		System.out.println("list...");
		List<Board> list = service.selectAll();

		model.addAttribute("list", list);
		return "list";// view name
	}	

	@GetMapping(value = "/read")
	public String read(Model model, @RequestParam("num") String num)throws Exception  {
		Board b = service.selectOne(num);

		model.addAttribute("b", b);
		return "read";// view name
	}
	
	@GetMapping(value = "/modify")
	public String modify(Model model, String num)throws Exception  {	
		Board b = service.selectOne(num);
		model.addAttribute("b", b);
		return "modify";// view name
	}
	
	@PostMapping(value = "/modifyProcess")
	public String modifyProcess(Board b)throws Exception  {
		service.modify(b);
		return "redirect:/list";// view name
	}

	@GetMapping(value = "/insertForm") // �엯�젰�솕硫�
	public String insertForm() {
		return "insertForm";// view name
	}

	@PostMapping(value = "/insertProcess") 
	public String insertProcess(@ModelAttribute Board b) throws Exception {

		service.insert(b);
		return "redirect:/list";// redirect
	}

	@GetMapping(value = "/delete")
	public String delete(Model model, String num)throws Exception  {
		
		service.delete(num);
		return "redirect:/list";// view name
	}
	
	@GetMapping(value = "/test")
	public String test()throws Exception  {
		service.txtest();
		return "list";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mnv = new ModelAndView();
		System.out.println(ex.getClass().getName());
		// if (e instanceof ArithmeticException) { }
		mnv.addObject("msg", "do well!!!");
		mnv.setViewName("error/error");
		return mnv;
	}
	
	@PostMapping(value = "/search")
	public String search(Model model, String condition, String word) throws Exception{
		List<Board> list = service.search(condition, word);

		model.addAttribute("list", list);
		return "list";
	}
}
