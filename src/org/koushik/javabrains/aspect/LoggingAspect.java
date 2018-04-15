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

@Aspect
public class LoggingAspect {
	
	
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint){
		//System.out.println("Advice run. Get Method Called");
		//System.out.println(joinPoint.toString());
		/*System.out.println(joinPoint.getTarget());
		Circle  circle = (Circle)joinPoint.getTarget();*/
	}
	
	//@Before("args(String)")
	//@Before("args(name)") // method having single param
	//@After("args(name)")
	/*@AfterReturning("args(name)") // run only when method return without any exception
	public void stringArgumentMethods(String name){
		System.out.println("A method that takes string arguments has been calle. The value is- "+name);
	}*/
	
	@AfterReturning(pointcut="args(name)",returning="returnString") // run only when method return without any exception
	public void stringArgumentMethods(String name,Object returnString){
		System.out.println("A method that takes string arguments has been called. The value is- "+name +" and the output value is : "+returnString);
	}
	
	/*@AfterThrowing("args(name)")
	public void exceptionAdvice(String name){
		System.out.println("An exception has been thrown.");
	}*/
	
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex){
		System.out.println("An exception has been thrown.  " +  ex);
	}
	
	//@Around("allGetters()")
	@Around("@annotation(org.koushik.javabrains.aspect.Loggable)")
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
	
	@Pointcut("execution( * get*())")
	public void allGetters(){
		
	}
	
	//@Pointcut("execution(* org.koushik.javabrains.service.*.*(..))")
	//@Pointcut("execution(* org.koushik.javabrains.service.*Service.*(..))")
	
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")
	public void allCircleMethods(){}
	
	
}


