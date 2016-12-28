package com.packt.process;

import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class SpawnedProcessInfoDemo{
	public static void main(String [] args) throws IOException, InterruptedException{
		ProcessBuilder pBuilder = new ProcessBuilder("sleep", "20");
		Process p = pBuilder.inheritIO().start();

		ProcessHandle ph = p.toHandle();

		ProcessHandle.Info info = ph.info();

		int exitValue = p.waitFor();

		System.out.println("Command line: " + info.commandLine().get());
		System.out.println("Command: " + info.command().get());
		System.out.println("Arguments: " + info.arguments().get());
		System.out.println("User: " + info.user().get());
		System.out.println("Start: " + info.startInstant().get());
		System.out.println("Total CPU time(ms): " + info.totalCpuDuration().get().toMillis());

		System.out.println("PID: " + handle.getPid());
	}
}