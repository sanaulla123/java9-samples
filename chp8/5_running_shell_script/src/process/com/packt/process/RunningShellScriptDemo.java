package com.packt.process;

import java.io.IOException;
import java.io.File;

public class RunningShellScriptDemo{
	public static void main(String[] args)
		throws IOException, InterruptedException {

		ProcessBuilder pb = new ProcessBuilder();
		
		pb.directory(new File("/root/java9-samples/chp8/5_running_shell_script"));

		System.out.println(pb.directory());

		pb.command("/bin/bash", "script.sh").inheritIO();

		Process p = pb.start();

		int exitValue = p.waitFor();
	}
}