package com.springAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogic {
	
	public AspectLogic() {
		System.out.println("Aspect object created in context");
	}
	
	// With this advice it will intercept every method possible even if it is a Getter and Setter
	@Around("execution(* com.springAspect.CommentAspectService.*(..))")   // Tried it with * but got an error
	public void intercept(ProceedingJoinPoint joinPoint) throws Throwable {
		String nameOfTheMethod = joinPoint.getSignature().getName();  // Access the name of the Method and get it
		Object [] parameters = joinPoint.getArgs();  // This will give me the object [] of whatever type of object/objects are passed in the parameter
		
		System.out.println(nameOfTheMethod);
		for(Object a  : parameters) {
			System.out.println(a);
		}
		System.out.println("Now calling the intercepted method");
		System.out.println("Altering the comment and then passing it to the intercepted method");
		Comment comment = new Comment();
		comment.setAuthor("Shivam");
		comment.setText("Time Pass");
		Object [] objects = {comment};
		joinPoint.proceed(objects);
		System.out.println("Here after calling the Intercepted Method");
	}
	
}
