package com.coderscampus.myapp.main;

import com.coderscampus.myapp.service.MyService;

public class App {
	
	private MyService myService = new MyService();
	
	public static void main(String[] args) {
		new App().execute();
	}

	private void execute() {
		// Your code goes here, not in the main() method
		// This removes any need to consume statics
		// The code below is to be deleted once you understand what it does
		System.out.println(AppConstants.EXAMPLE_CONSTANT);
		System.out.println(" 2 * 17 = " + myService.multiply(2, 17));
		System.out.println("Contents of the file at " + AppConstants.EXAMPLE_FILE_PATH);
		System.out.println(myService.fileContents(AppConstants.EXAMPLE_FILE_PATH));
	}

}
