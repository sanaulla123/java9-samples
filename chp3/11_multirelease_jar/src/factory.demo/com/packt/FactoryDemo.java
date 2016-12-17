package com.packt;

import java.util.Map;
import java.util.Set;
import java.util.List;

public class FactoryDemo{
	public static void main(String[] args){
		Map<String, String> map = Map.of("type", "map", "java", "9");
		List<String> list = List.of("list", "java", "9");
		Set<String> set = Set.of("set", "java", "9");
		System.out.println(map);
		System.out.println(list);
		System.out.println(set);
	}

}