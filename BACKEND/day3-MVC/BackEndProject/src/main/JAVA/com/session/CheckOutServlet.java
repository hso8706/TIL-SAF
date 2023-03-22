package com.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//쇼핑백 보기, 계산하기
@WebServlet(name = "CheckOutServlet", value = "/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        //1) 세션 얻기
        HttpSession session = request.getSession(false);
        //false : session 정보를 얻되 만들 필요가 없을 경우
        //:기존 세션 유무를 체크해서 있으면 그거 리턴하고, 없으면 null 리턴

        String msg = "";

        if (session == null) { // 장바구니에 물건이 없는 경우 => session 을 만든 적이 없는 경우
            msg = "장바구니안에 물건이 없습니다.";
        } else {
            //세션이 있다면, 세션안의 데이터에 접근
            int[] tomato = (int[]) session.getAttribute("tomato");
            int[] orange = (int[]) session.getAttribute("orange");
            
            //id == see: 쇼핑백 보기, checkout: 계산하기
            if(id.equals("see")){
                msg = "장바구니 안의 토마토는 " + tomato[0] + "개, 오렌지는 " + orange[0] + "개 입니다.";
            }else{
                msg = "계산이 완료되었습니다. 장바구니는 비었습니다.";
                session.invalidate(); // 세션 무효화, 장바구니가 비워지면 남아있을 의미가 없음
//                session.setAttribute("tomato", null); // 혹은 이런식으로 null로 값을 덮어씌우기도 가능.
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<h1>쇼핑백 내용</h1>");
        out.println(msg + "<hr>");
        out.println("<a href=ShopServlet>쇼핑하러가기</a>");
    }
}
