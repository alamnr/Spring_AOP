package org.koushik.javabrains.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	//@Before("execution(public String org.koushik.javabrains.model.Circle.getName())")
	//@Before("execution(public String getName())")
	//@Before("execution(public String get*())")
	//@Before("execution(public * get*())")
	//@Before("execution( * get*())")
	//@Before("execution( * get*(*))")
	//@Before("execution( * get*(..))")
	//@Before("execution( * org.koushik.javabrains.model.*.get*(..))")
	@Before("allGetters()")
	public void LoggingAdvice(){
		System.out.println("Advice run. Get Method Called");
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice executed.");
	}
	
	@Pointcut("execution( * get*())")
	public void allGetters(){
		
	}
	

}
