package com.ssafy.homework.controller;

import com.ssafy.homework.service.UserService;
import com.ssafy.homework.service.UserServiceImpl;
import com.ssafy.homework.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController {
    UserService service;

    public UserController() {
        service = new UserServiceImpl();
    }

    public void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //home.jsp - button(loginCheck): user 정보가 없으면 로그인 버튼만 출력, 로그인 버튼(loginForm)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
        dispatcher.forward(request, response);
    }

    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 사용자 입력 : id, pass ,remember
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");//"on" or "null"

        //2. 받아온 값으로 User 객체 생성
        User user = new User(id, pass);
        //3. 입력 정보가 맞는지 체크
        boolean flag = service.check(user);
        String url = "home"; // 로그인 정보가 정상 처리될 경우 default url
        // 로그인 정보에 대한 session, cookie 처리
        if(flag){ // 로그인 성공 시 작업 : 로그인 정보를 세션에 저장하고 초기화면으로 가기
            HttpSession session = request.getSession(); //session 객체 오픈
            session.setAttribute("user", user); // session 값 저장, ("user" : user)

            //cookie 처리
            if(remember != null){ // 체크박스 체크한 경우, "on"이 입력됨
                Cookie remem = new Cookie("remem", id); //cookie 객체 오픈 및 값 저장
                remem.setMaxAge(-1); // 인자: 유효 기간, -1인 경우: 창이 열려있을 때만 유지
                response.addCookie(remem);
            }
            else { // 체크박스 해제한 경우, "null"이 입력됨
                Cookie remem = new Cookie("remem", ""); //cookie 객체 오픈
                remem.setMaxAge(0); // 0 : 쿠키 저장 안됨
                response.addCookie(remem);
            }

        }
        else { // 로그인 실패 시 작업 : 로그인 화면으로 돌리기
            request.setAttribute("msg", "로그인 정보를 확인해 주세요!");
            url = "loginForm";
        }
        response.sendRedirect(url);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 로그인 처리가 된 경우 home.jsp 에는 `로그인`이 아닌 `로그아웃` 버튼 존재
        // 세션 오픈 - 세션 로그인 정보 삭제 - 초기화면 리다이렉트
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        response.sendRedirect("home");
    }
}
