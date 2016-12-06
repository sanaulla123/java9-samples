package com.packt.calculator.commands;

import com.packt.math.MathUtil;

public class PrimeCheckCommand implements Command{
	public final Integer number;
	public PrimeCheckCommand(Integer n){
		number = n;
	}

	@Override
	public void execute(){
		if (MathUtil.isPrime(number)){
			System.out.println("The number " + number +" is prime");
		}else{
			System.out.println("The number " + number +" is not prime");
		}
	}
}