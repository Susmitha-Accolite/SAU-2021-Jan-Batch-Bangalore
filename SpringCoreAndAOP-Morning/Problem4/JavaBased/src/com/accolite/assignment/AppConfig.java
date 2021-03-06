package com.accolite.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(name = "rectangleObject")
	public Rectangle rectangle() {
		return new Rectangle();
	}
	@Bean(name = "PointA")
	public Point pointAObj() {
		return new Point(0,0);
	}
	@Bean(name = "PointB")
	public Point pointBObj() {
		return new Point(0,3);
	}
	@Bean(name = "PointC")
	public Point pointCObj() {
		return new Point(3,0);
	}
	@Bean(name = "PointD")
	public Point pointDObj() {
		return new Point(1,3);
	}
}
