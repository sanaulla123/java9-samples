package com.packt.calculator.commands;

import com.packt.banking.BankUtil;

public class CompoundInterestCommand implements Command{
	public final Double principal;
	public final Integer rateInPercent;
	public final Integer noOfCompoundsPerYear;
	public final Integer duration;

	public CompoundInterestCommand(Double principal, Integer rateInPercent, 
		Integer noOfCompoundsPerYear, Integer duration){
		this.principal = principal;
		this.rateInPercent = rateInPercent;
		this.noOfCompoundsPerYear = noOfCompoundsPerYear;
		this.duration = duration;
	}

	@Override
	public void execute(){
		Double interest = BankUtil.computeCompoundInterest(principal, rateInPercent, 
			noOfCompoundsPerYear, duration);

		System.out.println(String.format("Compound Interest is %f", interest));
	}
}