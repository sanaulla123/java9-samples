package com.packt.process;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChangeWorkDirectoryDemo{
	public static void main(String[] args) 
		throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("tree")
		  .inheritIO()
		  .directory(new File("/root/java9-samples/chp8"));

		Process p = pb.start();

		int exitValue = p.waitFor();
		
	}
}