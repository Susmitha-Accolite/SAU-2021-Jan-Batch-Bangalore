package com.assignment.junit;

public class LeapYear {

	public boolean isleapyear(int yr) {
		return (yr % 4 == 0 && (yr % 100 !=  0 || yr % 400 == 0));
	}
}
