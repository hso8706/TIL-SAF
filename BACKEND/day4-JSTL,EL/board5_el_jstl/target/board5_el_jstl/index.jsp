<%--<%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--	pageEncoding="UTF-8" import="com.ssafy.member.model.MemberDto"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:if test="${cookie.ssafy_id.value ne null}">
    <c:set var="checked" value=""></c:set>
    <c:set var="saveId" value="${pageContext.request.contextPath}"></c:set>
</c:if>
<%
//String root = request.getContextPath(); //  요청에 대한 contextPath 를 얻어옴 // jstl로 수정

//MemberDto memberDto = (MemberDto) session.getAttribute("userinfo"); //set 이전에는 memberDto == null // jstl로 수정

String checked = "";
String saveId = "";
Cookie[] cookies = request.getCookies();
if(cookies != null) {
	for(Cookie cookie : cookies) {
		if("ssafy_id".equals(cookie.getName())) {
			checked = " checked";
			saveId = cookie.getValue();
			break;
		}
	}
}
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
<%--    <link href="<%= root %>/assets/css/app.css" rel="stylesheet" /> //root 수정--%>
    <link href="${root}/assets/css/app.css" rel="stylesheet" />
    <title>SSAFY</title>
  </head>
  <body>
<c:if test="${empty userinfo}">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="orange">로그인</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-login" method="POST" action="">
            <input type="hidden" name="action" value="login" />
            <div class="form-check mb-3 float-end">
              <input
                class="form-check-input"
                type="checkbox"
                value="ok"
                id="saveid"
                name="saveid"
                ${checked}
              />
              <label class="form-check-label" for="saveid"> 아이디저장 </label>
            </div>
            <div class="mb-3">
              <label for="userid" class="form-label">아이디 : </label>
              <input
                type="text"
                class="form-control"
                id="userid"
                name="userid"
                placeholder="아이디..."
                value="${saveId}"
              />
            </div>
            <div class="mb-3">
              <label for="userpwd" class="form-label">비밀번호 : </label>
              <input
                type="password"
                class="form-control"
                id="userpwd"
                name="userpwd"
                placeholder="비밀번호..."
              />
            </div>

            <div class="text-danger mb-2">${msg}</div>
            <div class="col-auto text-center">
              <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">
                로그인
              </button>
              <button type="button" id="btn-mv-join" class="btn btn-outline-success mb-3">
                회원가입
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script>
      document.querySelector("#btn-mv-join").addEventListener("click", function () {
    	location.href = "${root}/user?action=mvjoin";
      });
      
      document.querySelector("#btn-login").addEventListener("click", function () {
        if (!document.querySelector("#userid").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-login");
          form.setAttribute("action", "${root}/user");
          form.submit();
        }
      });
    </script>
</c:if>
<c:if test="${!empty userinfo}">
    <div class="container">
	  <!-- 로그인 사용자 정보(로그아웃) 출력 -->
	  <%@ include file="/common/confirm.jsp" %>
<%--      <%= memberDto.getUserName() %>()--%>
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="orange">SSAFY 게시판 - MVC Pattern (with Session &amp; Cookie)</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12 text-center">
          <a href="${root}/article?action=mvwrite">글쓰기</a><br />
          <a href="${root}/article?action=list&pgno=1&key=&word=">글목록</a>
        </div>
      </div>
    </div>
</c:if>
  </body>
</html>
