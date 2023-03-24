package com.mvc.controller;

import com.mvc.service.UserService;
import com.mvc.service.UserServiceImpl;
import com.mvc.vo.User;

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
        // list.jsp 에서 `로그인` 버튼 존재
        // loginForm : 입력된 user 정보가 없으면 실행되는 메서드, loginCheck.jsp 화면으로 이동.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
        dispatcher.forward(request, response);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // list.jsp 에서 `로그아웃` 버튼 존재
        // logout : 입력된 user 정보가 있으면 실행되는 메서드, 세션에 저장한 정보를 삭제하고 초기화면으로 돌아가기
    }

    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 사용자가 입력한 값 받아오기(id, pass)
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");

        //2. 받아온 값으로 User 객체 생성
        User user = new User(id, pass);
        //3. 입력 정보가 맞는지 체크
        boolean flag = service.check(user);
        String url = "list"; // ok
        //4. 로그인 결과가 맞으면 로그인 정보 세션에 저장하고 초기화면으로 가기
        if(flag){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            url = "list";

            //cookie 처리
            if(remember != null){ // 체크박스를 체크한 경우
                Cookie remem = new Cookie("remem", id);
                remem.setMaxAge(-1); // 창이 열려있을 경우에만
                response.addCookie(remem);
            }
            else{ // 체크박스를 푼 경우
                //유효하지 않은 쿠키로 설정
                Cookie cookie = new Cookie("remem", "");
                cookie.setMaxAge(0); // 쿠키 저장 안 됨
                response.addCookie(cookie);
            }
        }
        //5. 로그인 결과가 틀리면 다시 로그인 화면으로 보내기
        else{ // 로그인 실패
            request.setAttribute("msg", "로그인 정보를 확인해 주세요!");
            url = "loginForm";
            response.sendRedirect(url);
        }

    }
}
