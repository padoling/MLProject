package com.ja.mlproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class ServiceLog {
	// 로그를 찍을 파일명
	@Pointcut("execution(* com.ja.mlproject.service..*Impl.*(..))")
	public void servicePointCut() {}
	

	// Pointcut에 해당하는 메소드를 어노테이션 인자로 넣어줌.
	@Around("servicePointCut()")
	public Object printServiceLog(ProceedingJoinPoint pjp) {
		Object obj = null;
		
		System.out.println("======= " + pjp.getSignature().getName() + " : 시작=======");
		
		try {
			obj = pjp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}

		System.out.println("======= " + pjp.getSignature().getName() + " : 끝=======");

		return obj;	
	}
	
}
