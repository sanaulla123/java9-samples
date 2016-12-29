package com.packt.process;

import java.util.Stream;

public class EnumerateProcessDemo{
	public static void main(String[] args) throws Exception{
		Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();

		liveProcesses.forEach(ph -> {
			ProcessHandle.Info phInfo = ph.info();
			System.out.println(phInfo.command().orElse("") +" " + phInfo.user().orElse(""));
		});
	}
}