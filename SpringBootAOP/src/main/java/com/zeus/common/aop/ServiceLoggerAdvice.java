package com.zeus.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ServiceLoggerAdvice {
	
	//조인포인트(핵심코드) 실행전에 작동
//	@Before("execution(* com.zeus.service.BoardService*.*(..))")
//	public void startLog(JoinPoint jp) {
//		log.info("ServiceLoggerAdvice.startLog");
//		log.info("ServiceLoggerAdvice.startLog jp.signature"+jp.getSignature()); // 적용되는 핵심코드의 구조를 보여줌 
//		log.info("ServiceLoggerAdvice.startLog jp.args"+Arrays.toString(jp.getArgs())); 
//		log.info("=================================================================="); 
//	}
//	@After("execution(* com.zeus.service.BoardService*.*(..))", returning = "result")
//	public void stopLog(JoinPoint jp, Object result) {
//		log.info("ServiceLoggerAdvice.stopLog");
//		log.info("******************************************************************"); 
//	}
//	@AfterReturning("execution(* com.zeus.service.BoardService*.*(..))")
//	public void stopLog(JoinPoint jp) {
//		log.info("ServiceLoggerAdvice.stopLog");
//		log.info("******************************************************************"); 
//	}
	//조인포인트(핵심코드) 전, 후 작동
	@Around("execution(* com.zeus.service.BoardService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		//앞에서 advice 실행한다.
		long startTime = System.currentTimeMillis();
		//조인포인트(핵심코드) 실행한다.
		Object obj = null;
		try {
			obj = pjp.proceed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//뒤에서 advice 실행한다.
		long stopTime = System.currentTimeMillis();
		//부산물
		log.info(pjp.getSignature().getName()+":"+(stopTime - startTime));
		log.info("-----------------------------------------------------");
		return null;
	}
	
}
