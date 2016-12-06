package com.packt.calculator.commands;

import com.packt.math.MathUtil;

public class SumPrimesCommand implements Command{
	public final Integer count;
	public SumPrimesCommand(Integer count){
		this.count = count;
	}

	@Override
	public void execute(){
		System.out.println(String.format("Sum of %d primes is %d", 
			count, MathUtil.sumOfFirstNPrimes(count)));
	}
}