package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
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
	@Before("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("A method that takes string arguments has been calle. The value is- "+name);
	}
	
	@Pointcut("execution( * get*())")
	public void allGetters(){
		
	}
	
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")
	public void allCircleMethods(){}
	
	
}


