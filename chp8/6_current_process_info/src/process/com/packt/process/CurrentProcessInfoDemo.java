package com.packt.process;

import java.time.Instant;
import java.time.Duration;

public class CurrentProcessInfoDemo{
	public static void main(String[] args)
		throws InterruptedException {
		ProcessHandle handle = ProcessHandle.current();
		
		for ( int i = 0 ; i < 1000000; i++){
			Thread.sleep(1000);
		}
		
		ProcessHandle.Info info = handle.info();

		System.out.println("Command line: " + info.commandLine().get());
		System.out.println("Command: " + info.command().get());
		System.out.println("Arguments: " + info.arguments().get());
		System.out.println("User: " + info.user().get());
		System.out.println("Start: " + info.startInstant().get());
		System.out.println("Total Duration: " + info.totalCpuDuration().get());
		System.out.println("PID: " + handle.getPid());
	}
}