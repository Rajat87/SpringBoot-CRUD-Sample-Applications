package com.springXML.SpringCoreUsingAnnot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RandomAspect {
	
	public RandomAspect() {
		System.out.println("Aspect Object Created");
	}

	@Around("execution(* com.springXML.SpringCoreUsingAnnot.*.*(..))")
	public void execute(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("In Aspect Logic");
		joinPoint.proceed();
	}
}
