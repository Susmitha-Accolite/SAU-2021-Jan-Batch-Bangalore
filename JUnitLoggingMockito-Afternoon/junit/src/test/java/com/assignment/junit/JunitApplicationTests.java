package com.assignment.junit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitApplicationTests {

	@Test
	public void testcase1() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(1900);
		assertEquals(false, actual);
	}
	
	@Test
	public void testcase2() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(2016);
		assertEquals(true, actual);
	}
	
	@Test
	public void testcase3() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(2020);
		assertEquals(true, actual);
	}
	
	
	@Test
	public void testcase4() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(1991);
		assertEquals(false, actual);
	}
	
	@Test
	public void testcase5() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(2004);
		assertEquals(true, actual);
	}
	
	@Test
	public void testcase6() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(1994);
		assertEquals(false, actual);
	}
}
