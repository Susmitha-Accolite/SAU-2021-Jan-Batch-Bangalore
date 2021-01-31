package com.assignment.mockito;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
class MockitoApplicationTests {

	Class1 mock1 = new Class1();
	Class2 mock2 = new Class2();

	@Test
	public void testUpperCase() {
		Class1 mock1 = mock(Class1.class);
		when(mock1.getName()).thenReturn("Susmitha");
		String str = mock2.uppercase(mock1);
		assertEquals("SUSMITHA", str);
	}

	@Test
	public void testRoleCourse1() {
		Class2 mock2 = mock(Class2.class);
		when(mock2.getRole()).thenReturn("Intern");
		String res = mock1.roleCourse(mock2);
		assertEquals("Intern: Mockito", res);
	}

}
