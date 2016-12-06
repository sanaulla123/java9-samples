package com.packt.calculator.commands;

import com.packt.math.MathUtil;

public class EvenCheckCommand implements Command{
	public final Integer number;
	public EvenCheckCommand(Integer n){
		number = n;
	}

	@Override
	public void execute(){
		if (MathUtil.isEven(number)){
			System.out.println("The number " + number +" is even");
		}else{
			System.out.println("The number " + number +" is odd");
		}
	}
}