package com.coderscampus.myapp.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.coderscampus.assignment.Assignment8;

public class App {

	public static void main(String[] args) {

		Assignment8 assignment8 = new Assignment8();//instantiate assignment 8

		//create thread safe list to hold all numbers
		List<Integer> collectedNumbers = Collections.synchronizedList(new ArrayList<>(1000));

		//instantiate executor service because CPU bound, cachedThread pool because short wait time between jobs
		ExecutorService executor = Executors.newCachedThreadPool();

		List<CompletableFuture<Void>> work = new ArrayList<>(1000);

		for (int i = 0; i < 1000; i += 1) {
			CompletableFuture<Void> doWork = CompletableFuture.supplyAsync(() -> assignment8
															  .getNumbers(), executor)//get blocks of 1000 numbers
															  .thenAccept(numbers -> collectedNumbers
															  .addAll(numbers));
			
			//add the numbers to completableFuture array list work
			work.add(doWork);
		}
		//sleep the main thread to ensure all jobs (doWork) are completed before printing result 
		while (work.stream().filter(CompletableFuture::isDone).count() < 1000) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}

		System.out.println("Got all the numbers");
		System.out.println("We have " + collectedNumbers.size() + " numbers");
		
		Counter counter = new Counter();
		Map<Integer, Integer> outPut = counter.count(collectedNumbers);

		System.out.println(outPut);
		
		executor.shutdown();
	}

}
//fetch all the numbers from the numbers list asynchronously,
//and determine the number of times each number appears in the list

//instantiate assignment 8
//create a synchronized list, cached thread pool, completablefuture list

