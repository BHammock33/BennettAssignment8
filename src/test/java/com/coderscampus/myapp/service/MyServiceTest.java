package com.coderscampus.myapp.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.coderscampus.myapp.main.AppConstants;

class MyServiceTest {

	private MyService myService = new MyService();

	@Test
	void testMultiply() {
		assertEquals(34, myService.multiply(2, 17));
	}
	
	@Test
	void testFileContents() {
		assertTrue(myService.fileContents(AppConstants.EXAMPLE_FILE_PATH).startsWith("File line #1"));
	}

}
