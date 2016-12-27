package com.packt.process;

import java.time.Instant;
import java.time.Duration;

public class CurrentProcessInfoDemo{
	public static void main(String[] args)
		throws InterruptedException {
		ProcessHandle handle = ProcessHandle.current();
		
		Thread.sleep(10000);
		
		ProcessHandle.Info info = handle.info();

		System.out.println("Command line: " + info.commandLine());
		System.out.println("Command: " + info.command());
		System.out.println("Arguments: " + info.arguments());
		System.out.println("User: " + info.user());
		System.out.println("Start: " + info.startInstance());
		System.out.println("Total Duration: " + info.totalCpuDuration().toSeconds());
		System.out.println("PID: " + handle.getPid());
	}
}