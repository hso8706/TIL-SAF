package com.mvc.controller;

import com.mvc.service.BoardService;
import com.mvc.service.BoardServiceImpl;
import com.mvc.vo.Board;
import com.mvc.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//FrontController 에게서 요청을 넘겨 받아 Service 에게 작업을 넘김
public class BoardController {
    //선언은 interface 타입, 생성은 impl 객체
    BoardService service; // service에 작업을 넘기기 위함

    public BoardController() {
        service = new BoardServiceImpl(); //impl 객체
    }

    //list(): data 를 전부 호출하여 메인 페이지 화면에 띄운다.
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Board> list = service.selectAll(); //data 발생, DB 에서 모든 data 호출, 해당 작업을 위해 Service-DAO 에게 작업 전달
        request.setAttribute("list", list); // data 를 request 를 이용하여 넘겨주기 위함(forward 방식 이용)

        //화면 구성하러 jsp로 gogo => forward 방식으로 넘어감(dispatcher 사용)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
        dispatcher.forward(request, response);
    }
    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num"); // list.jsp 로부터 클릭한 게시물의 번호를 제공받음 (/read?num= )
        Board b = service.selectOne(num); // DB 에서 호출한 하나의 row 값을 저장한 Board 객체
        request.setAttribute("b", b); // data 를 request 를 통해 넘겨줌(forward 방식 이용)

        //화면 구성하러 jsp로 gogo => forward 방식으로 넘어감(dispatcher 사용)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");
        dispatcher.forward(request, response);
    }


    public void insertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //화면 이동만을 위한 메서드 => 로그인 연관 기능 추가
        String url = "/views/insertFrom.jsp"; // 새 글 등록 화면
        
        HttpSession ses = request.getSession(); 
        if(ses.getAttribute("user") == null){//로그인이 안 되어있는 경우
            url = "/views/loginForm.jsp"; // 로그인 화면으로 재이동
        }
        
        //화면 구성하러 jsp로 gogo => forward 방식으로 넘어감(dispatcher 사용)
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void insertProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // form 태그 하위 input 태그의 name 속성 값으로 넘어온 값들
        String title = request.getParameter("title");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        Board b = new Board(null, pass, name, null, title, content, null); // 제공받은 값으로 DB에 넣은 Board 객체 생성
        int check = service.insert(b); // db 에 넣어주고, 넣은 data 개수(row 개수)를 반환받음.

        response.sendRedirect("/mvc/list"); // 작업이 끝나면 자동으로 /list view 로 넘어가도록 설정(redirect 방식을 이용)
    }


    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num"); //list.jsp view 에서 전달받을 인자, 제공받은 num 에 해당하는 게시물을 삭제한다 (현재 list 에 버튼 구현되어있지 않음.)
        int x = service.delete(num);
        try {
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
