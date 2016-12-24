package com.packt.process;

import java.io.IOException;
import java.io.File;

public class RunningShellScriptDemo{
	public static void main(String[] args)
		throws IOException, InterruptedException {

		ProcessBuilder pb = new ProcessBuilder();

		pb.command("script.sh").inheritIO();

		Process p = pb.start();

		int exitValue = p.waitFor();
	}
}