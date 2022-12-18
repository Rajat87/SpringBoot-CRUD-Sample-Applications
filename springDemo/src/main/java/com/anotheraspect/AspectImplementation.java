package com.anotheraspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectImplementation {
	@Around("execution(* com.anotheraspect.*.*(..))")
	public Object interceptingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Aspect Logic executed");
		Object[] objects = (Object[])joinPoint.getArgs();
		// I didn't even delegate to the original method I just sent a custom value.
		//joinPoint.proceed();
		Object [] newInput = {10,20};
		return joinPoint.proceed(newInput);
		
	}
}
