package com.packt.process;


public class NewProcessDemo{
	public static void main(String [] args){
		ProcessBuilder pBuilder = new ProcessBuilder("top");
		Process p = pBuilder.inheritIO().start();
		if(p.waitFor(1, TimeUnit.SECONDS)){
			System.out.println("process completed successfully");
		}else{
			System.out.println("waiting time elapsed, process did not complete");
		}
	}
}