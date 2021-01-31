package com.assignment.junit;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitApplication {

	public static void main(String[] args) {
		LeapYear yrObj = new LeapYear();
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		if(yrObj.isleapyear(year))
			System.out.println(year+" is a leap year");
		else
			System.out.println(year + " is not a leap year");
	}

}
