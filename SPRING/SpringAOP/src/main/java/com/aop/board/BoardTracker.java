package com.aop.board;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BoardTracker {

	/*
	 * before
	 * : for login check
	 * : for write, delete
	 */
	@Before("execution(void write(String)) || execution(void delete(int))")
//	@Before("execution(void *te(*))") // 가능
	public void boardTrack(JoinPoint jp) {
		System.out.println("Before advice 시작 =================");
		System.out.println("target: " + jp.getTarget().getClass().getName()); // before 애너테이션에 걸린 joinpoint 정보
		System.out.println("method: " + jp.getSignature().getName());
		System.out.println("args: " + jp.getArgs()[0]);
		System.out.println("Before advice 끝 =================");
	}
	
	/*
	 * after
	 * : for read
	 */
	@After("execution(String read(*))")
	public void boardTrack2(JoinPoint jp) {
		System.out.println("After advice 시작 =================");
		System.out.println("target: " + jp.getTarget().getClass().getName()); // before 애너테이션에 걸린 joinpoint 정보
		System.out.println("method: " + jp.getSignature().getName());
		System.out.println("args: " + jp.getArgs()[0]);
		System.out.println("After advice 끝 =================");
	}
}
