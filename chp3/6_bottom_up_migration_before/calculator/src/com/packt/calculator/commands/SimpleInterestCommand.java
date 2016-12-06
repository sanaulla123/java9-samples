package com.packt.calculator.commands;

import com.packt.banking.BankUtil;

public class SimpleInterestCommand implements Command{
	public final Double principal; 
	public final Integer rate; 
	public final Integer duration;

	public SimpleInterestCommand(Integer principal, Integer rate, Integer duration){
		this.principal = principal;
		this.rate = rate;
		this.duration = duration;
	}

	@Override
	public void execute(){
		Double interest = BankUtil.computeSimpleInterest(principal, rate, duration);
		System.out.println(String.format("Simple Interest is %f", interest));
	}
}