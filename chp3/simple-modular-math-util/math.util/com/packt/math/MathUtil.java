package com.packt.math;
import java.util.stream.IntStream;
import java.util.function.IntPredicate;

public class MathUtil{

	public Boolean isPrime(Integer number){
		if ( number == 1 ) { return false; }
		return IntStream.range(2,number)
						.noneMatch(i -> number % i == 0 );
	}

	/** find sum of prime number <= limit */
	public Integer sumOfFirstNPrimes(Integer count){
		return computeFirstNSum(count, (i -> isPrime(i)));
	}

	public Boolean isEven(Integer number){
		return number % 2 == 0;
	}

	public Integer sumOfFirstNEvens(Integer count){
		return computeFirstNSum(count, (i -> isEven(i)));
	}

	public Integer sumOfFirstNOdds(Integer count){
		return computeFirstNSum(count, (i -> !isEven(i)));
	}

	private Integer computeFirstNSum(Integer count, IntPredicate filter){
		return IntStream.iterate(1,i -> i+1)
						.filter(filter)
						.limit(count).sum();
	}

}