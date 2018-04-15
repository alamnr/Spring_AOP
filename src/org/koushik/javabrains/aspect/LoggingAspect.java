package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.koushik.javabrains.model.Circle;

//@Aspect
public class LoggingAspect {
	
	
	//@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		
		Object returnValue=null;
		try {
			// before execution advice code goes here
			System.out.println("Before Advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Advice");
		} catch (Throwable e) {
			System.out.println("After throwing ");
			e.printStackTrace();
		}  // Target method get executed here
		
		System.out.println("After finally");
		//after execution advice code goes here
		
		return returnValue;
	}
	
	/*@Pointcut("execution( * get*())")
	public void allGetters(){
		
	}*/
	
	public void loggingAdvice(){
		System.out.println("Logging from the Advice");
	}
	
}


