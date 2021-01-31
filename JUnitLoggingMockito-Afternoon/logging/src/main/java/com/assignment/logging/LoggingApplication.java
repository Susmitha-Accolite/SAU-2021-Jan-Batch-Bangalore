package com.assignment.logging;

import org.springframework.boot.SpringApplication;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingApplication {

	private static Logger logger = Logger.getLogger(LoggingApplication.class);
	
	public static void main(String[] args) {
		 BasicConfigurator.configure();
	        Scanner in = new Scanner(System.in);
	        System.out.println("Enter the Logger Level from 1 to 7");
	        System.out.println("Enter your choice: \t");
	        int ch = in.nextInt();
	        switch (ch) {
	            case 1:
	                logger.setLevel(Level.ALL);
	                break;
	            case 2:
	                logger.setLevel(Level.DEBUG);
	                break;
	            case 3:
	                logger.setLevel(Level.INFO);
	                break;
	            case 4:
	                logger.setLevel(Level.WARN);
	                break;
	            case 5:
	                logger.setLevel(Level.ERROR);
	                break;
	            case 6:
	                logger.setLevel(Level.FATAL);
	                break;
	            case 7:
	                logger.setLevel(Level.OFF);
	                break;
	        }
	        logger.trace("Trace Message!");
	        logger.debug("Debug Message!");
	        logger.info("Info Message!");
	        logger.warn("Warn Message!");
	        logger.error("Error Message!");
	        logger.fatal("Fatal Message!");
	   }
}
