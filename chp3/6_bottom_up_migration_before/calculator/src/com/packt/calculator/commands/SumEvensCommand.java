package com.packt.calculator.commands;

import com.packt.math.MathUtil;

public class SumEvensCommand implements Command{
	public final Integer count;
	public SumEvensCommand(Integer count){
		this.count = count;
	}

	@Override
	public void execute(){
		System.out.println(String.format("Sum of %d evens is %d", 
			count, MathUtil.sumOfFirstNEvens(count)));
	}
}