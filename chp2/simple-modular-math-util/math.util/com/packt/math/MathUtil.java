package com.packt.math;

public class MathUtil{

	public Boolean isPrime(Integer number){
		return IntStream.range(2,num)
						.noneMatch(i -> num % i == 0 );
	}

	/** find sum of prime number <= limit */
	public Integer sumOfPrimes(Integer count){
		System.out.println("Sum of primes: " + count);
	}

	public Integer sumOfFibonacci(Integer count){
		System.out.println("Fibonacci sum: " + count);
	}
}