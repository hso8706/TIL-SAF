package com.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieTest", value = "/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1) 응답으로 제공하는 기본 설정
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //클라이언트의 요청 정보에서 쿠키 정보를 뽑아냄
        Cookie[] cookies = request.getCookies();
        if(cookies == null || cookies.length == 0){//jsp를 거치지 않고 바로 get 요청으로 들어온 경우라면, 쿠키가 없음. 해당 상황을 별도로 처리
            out.println("<html><body>");
            out.println("<h1>쿠키가 없습니다!</h1>");
            out.println("<a href=cookie/login.jsp>로그인 하러가기</a>");
            out.println("</body></html>");
        }else{ //cookie가 있는 경우
            out.println("<h1>Cookie Test</h1>");
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                String name = c.getName();
                String value = c.getValue();

                out.println(name + ":" + value + "<br>");
            }
            out.println("<a href=CookieTest>다시 방문하기</a>");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1) 클라이언트로부터 들어오는 한글 처리
        request.setCharacterEncoding("utf-8");
        //2) 클라이언트가 보내는 데이터 받기
        String id = request.getParameter("id"); //.getParameter() : html의 name 속성 값 기준으로 받아옴
        String pass = request.getParameter("pass");
        //3) 응답으로 제공하는 기본 설정
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //4) 클라이언트로부터 받은 정보(id, pass)를 이용해서 쿠키를 생성
        Cookie idCookie = new Cookie("id", id); // key, value 형식으로 저장
        Cookie passCookie = new Cookie("pass", pass);
        
        //5) 쿠키 속성 설정(만료 기간 등)
//        idCookie.setMaxAge(60*60*24*365); //만료 기간: 60초*60*24*365 == 1년; 억지로 삭제 안하면 1년 유지
        idCookie.setMaxAge(-1); //-1: 브라우저가 켜져있는 동안만 쿠키가 유지되는 값
        passCookie.setMaxAge(-1);

        //6) 응답 객체 안에 저장
        response.addCookie(idCookie);
        response.addCookie(passCookie);

        //7) 화면에 출력(html 작성)
        out.println("<html><body>"); // 사실 이 코드는 안적어도 무관
        out.println("<h1>쿠키 저장됨</h1>");
        out.println("<a href=CookieTest>다시 방문하기</a>"); // 링크를 통한 이동 => doGet
        out.println("</body></html>");
    }
}
