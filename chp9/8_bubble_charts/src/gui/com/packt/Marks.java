package com.packt;

public class Marks{
	public Integer id;
	public Integer firstTest;
	public Integer secondTest;
	public Integer thirdTest;
	public Integer fourthTest;
	public Integer midTerm;
	public Integer finalTerm;

	public Marks(Integer id, String[] elements){
		this.id = id;
		firstTest = Integer.parseInt(elements[0]);
		secondTest = Integer.parseInt(elements[1]);
		thirdTest = Integer.parseInt(elements[2]);
		fourthTest = Integer.parseInt(elements[3]);
		midTerm = Integer.parseInt(elements[4]);
		finalTerm = Integer.parseInt(elements[5]);
	}

}