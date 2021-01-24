package com.accolite.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Draw {

	public static void main(String[] args) {
		ApplicationContext config = new AnnotationConfigApplicationContext(AppConfig.class);
		Rectangle rectangle = (Rectangle) config.getBean("rectangleObject");
		rectangle.draw();
		
	}
}
