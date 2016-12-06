package com.packt.calculator.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public interface Command{
	private final ObjectMapper objectMapper = new ObjectMapper();
	public void execute();

	default void printInJson(Map<String, Object> data){
		System.out.println(objectMapper.writeValueAsString(data));
	}

}