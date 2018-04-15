package org.koushik.javabrains.service;

import org.koushik.javabrains.aspect.LoggingAspect;
import org.koushik.javabrains.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		System.out.println("proxy method");
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}

}
