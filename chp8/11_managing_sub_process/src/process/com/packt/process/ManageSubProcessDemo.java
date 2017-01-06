package com.packt.process;

import java.util.concurrent.*;

public class ManageSubProcessDemo{
	public static void main(String[] args) throws Exception{
		ExecutorService executor = Executors.newFixedThredPool(10);
		Callable<Process> task = () -> {
			return new ProcessBuilder("/bin/bash", "script.sh")
				.inheritIO()
				.start();
		};

		List<Future<Process>> tasksResponse = new ArrayList<>();

		for ( int i = 0; i < 10; i++){
			Future<Process> response = executor.submit(task);
			tasksResponse.add(response);
		}
		ProcessHandle currentProcess = ProcessHandle.current();
		
		System.out.println("Obtaining children");
		currentProcess.children().forEach(pHandle -> {
			System.out.println(pHandle);
		});

		System.out.println("Obtaining descendants");
		
		currentProcess.descendants().forEach(pHandle -> {
			System.out.println(pHandle);
		});

	}
}