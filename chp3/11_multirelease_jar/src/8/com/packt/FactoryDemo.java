package com.packt;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class FactoryDemo{
	public static void main(String[] args){
		Map<String, String> map = new HashMap<>();
		map.put("type", "map");
		map.put("java", "8");
		List<String> list = Arrays.asList("list", "java", "8");
		Set<String> set = new HashSet<>();
		set.add("set");
		set.add("java");
		set.add("8");
		System.out.println(map);
		System.out.println(list);
		System.out.println(set);
	}

}