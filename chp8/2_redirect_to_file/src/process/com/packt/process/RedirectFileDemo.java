package com.packt.process;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RedirectFileDemo{
	public static void main(String[] args) throws IOException{
		ProcessBuilder pb = new ProcessBuilder("iostat");
		Process p = pb.redirectError(new File("error"))
					  .redirectOutput(new File("output"))
					  .start();
		int exitValue = p.waitFor();

		System.out.println("Error");
		for(String line : Files.lines(Paths.get("error"))){
			System.out.println(line);
		}

		System.out.println("Output");
		for(String line : Files.lines(Paths.get("output"))){
			System.out.println(line);
		}
	}
}