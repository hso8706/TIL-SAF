package com.ssafy.controller;

import com.ssafy.service.UserServcie;
import com.ssafy.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class UserController {
    @Autowired
    UserServcie servcie;

    //TODO. LoginForm
    @GetMapping(value ="/loginForm")
    public String loginForm() {
        return "loginForm";
    }
    //TODO. LoginProcess
    //id, pass, admin 정보 전달 + remember
    //HttpSession, RedirectAttributes 사용
    @PostMapping(value ="/loginProcess")
    public String loginProcess(HttpSession session, String id, String pass, String admin, RedirectAttributes ra) throws SQLException {
        String url = "index"; // 기본 url
        User user = new User(id, pass); // 로그인 체크용 생성자

        if (admin == null){
            if (servcie.checkUser(user, admin)) session.setAttribute("user", user);
            else {
                ra.addFlashAttribute("msg", "ID/PW를 확인해 주세요!"); //alert 에러 메세지
                url = "loginForm";
            }
        }
        else {
            if (servcie.checkUser(user, admin)) {
                session.setAttribute("admin", "admin");
                session.setAttribute("user", user);
            }
            else {
                ra.addFlashAttribute("msg", "admin 정보를 확인해 주세요!"); //alert 에러 메세지
                url = "loginForm";
            }
        }

        return "redirect:/"+url;
    }
    //TODO. Logout
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        session.setAttribute("admin", null);

        return "redirect:/loginForm";
    }
}
