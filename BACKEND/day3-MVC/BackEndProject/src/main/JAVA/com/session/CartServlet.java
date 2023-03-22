package com.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//servlet으로 session 구현하기
@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    //링크를 통해 넘어오기 때문에 doGet 메서드만 사용
    //세션은 최초에만 생성하고 이후에는 해당 세션에 계속 저장.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        //1) 세션 생성: 기존 세션 유무를 체크해서 있으면 그거를 사용하도록 리턴시키고, 없으면 생성해서 리턴
        HttpSession session = request.getSession(true);

        //2) 세션안에 상품별 개수 저장할 배열 만들어서 저장
        if(session.isNew()) { // 세션이 처음 만들어 진 거라면
            session.setAttribute("tomato", new int[] {0});
            session.setAttribute("orange", new int[] {0});
            //session 은 tomato 와 orange 를 담는 박스
            //session 내에 데이터를 저장할 땐 객체만 가능, 기본 데이터는 불가능 => 때문에 배열로 개수를 저장
        }
        
        //3) 세션안의 정보 접근하기
        int[] tomato = (int[]) session.getAttribute("tomato"); //getAttribute 는 Object 형 반환
        int[] orange = (int[]) session.getAttribute("orange");
        
        //4) 체크
        String msg = "";
        if(id.equals("tomato")){
            tomato[0]++;
            msg = "토마토를 쇼핑백에 추가했습니다.";
        }else {
            orange[0]++;
            msg = "오렌지를 쇼핑백에 추가했습니다.";
        }
        
        msg += "<br>현재 토마토는 " + tomato[0] + "개, 오렌지는 " + orange[0] + "개 입니다.";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        out.println("<h1>쇼핑백 내용</h1>");
        out.println(msg + "<hr>");
        out.println("<a href=ShopServlet>쇼핑하러가기</a>");
    }
}
