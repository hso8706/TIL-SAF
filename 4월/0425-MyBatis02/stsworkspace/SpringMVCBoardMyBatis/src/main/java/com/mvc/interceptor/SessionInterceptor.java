package com.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
@Order(1)
public class SessionInterceptor implements HandlerInterceptor{
	/* Order로 인터셉터 간 실행 순서를 지정할 수 있다. 숫자가 낮으면 먼저 실행됨.
	 * 핸들러(컨트롤러)의 수정없이 핸들러 수행 전/후처리 동작을 추가하여 핸들러(컨트롤러)의 반복적인 코드를 제거하기 위함
	 * 사용자의 요청을 처리하기 전에 session에 login 정보가 있는지 판단한다.
	 * 정보가 있다면 그대로 진행하고, 정보가 없다면 로그인 페이지로 이동시킨다.
	 */
	//지정된 컨트롤러의 동작 이전에 수행할 동작 (사전 제어).
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle-1");
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			return true;//요청한 곳(컨트롤러)으로 이동
			
		}else {
			response.sendRedirect("loginForm");			
			return false;
		}
	}

 	//지정된 컨트롤러의 동작 이후에 처리할 동작 (사후 제어).
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			System.out.println("postHandle-1");
		
	}
	
	//View 렌더링 이후 클라이언트에게 Response를 전달하기 전에 추가적인 작업이 가능
	//Dispatcher Servlet의 화면 처리가 완료된 이후 처리할 동작.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
