package org.koushik.javabrains;

import org.koushik.javabrains.service.FactoryService;
import org.koushik.javabrains.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args){
		
	
		FactoryService factoryService  =  new FactoryService();
		ShapeService shapeService = (ShapeService)factoryService.getBean("shapeService");
		shapeService.getCircle();
		
	}

}
