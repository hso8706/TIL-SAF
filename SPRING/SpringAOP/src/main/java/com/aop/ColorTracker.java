package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//Aspect 객체: Advice(what) + Pointcut(when). 공통 업무를 포함하는 객체.

@Aspect // Aspect 객체임을 표기 => Proxy에게 정보를 주기 위함
public class ColorTracker {
	
	//메서드명은 중요하지 않음
	//Advice로 사용할 메서드 => annotation 필요 
	@Before("execution(void set*(*))")// void 반환형을 가진 + set으로 시작하는 메서드 + 아무 싱글 파라미터를 받는
	public void colorTrack(JoinPoint jp) {
		System.out.println("Before advice 시작 =================");
		System.out.println("target: " + jp.getTarget().getClass().getName()); // before 애너테이션에 걸린 joinpoint 정보
		System.out.println("method: " + jp.getSignature().getName());
		System.out.println("args: " + jp.getArgs()[0]);
		System.out.println("Before advice 끝 =================");
	}
	
	@After("execution(String get*())")// void 반환형을 가진 + set으로 시작하는 메서드 + 아무 싱글 파라미터를 받는
	public void colorTrack2(JoinPoint jp) {
		System.out.println("After advice 시작 =================");
		System.out.println("target: " + jp.getTarget().getClass().getName()); // before 애너테이션에 걸린 joinpoint 정보
		System.out.println("method: " + jp.getSignature().getName());
//		System.out.println("args: " + jp.getArgs()[0]);
		System.out.println("After advice 끝 =================");
	}
	
	@Around ("execution(void go(int))")// void 반환형을 가진 + set으로 시작하는 메서드 + 아무 싱글 파라미터를 받는
	public void colorTrack3(ProceedingJoinPoint jp) throws Throwable { // Target으로 보내기 위한 joinpoint
		//Target before에 시작
		System.out.println("Around before advice 시작 =================");
		System.out.println("target: " + jp.getTarget().getClass().getName()); // before 애너테이션에 걸린 joinpoint 정보
		System.out.println("method: " + jp.getSignature().getName());
		System.out.println("args: " + jp.getArgs()[0]);
		System.out.println("Around before advice 끝 =================");
		
		//Target 실행 이후로 시점 변경
		jp.proceed();
		
		//Target after에 시작
		System.out.println("Around after advice 시작 =================");
		System.out.println("target: " + jp.getTarget().getClass().getName()); // before 애너테이션에 걸린 joinpoint 정보
		System.out.println("method: " + jp.getSignature().getName());
		System.out.println("args: " + jp.getArgs()[0]);
		System.out.println("Around after advice 끝 =================");
	}
}
