import com.packt.math.util.MathUtil;

public class Calculator{

	public static void main(String[] args){
		System.out.println("Advanced Calculator");
		System.out.println("24 is prime? " + MathUtil.isPrime(24));
		System.out.println("23 is prime? " + MathUtil.isPrime(23));

		System.out.println("Sum of first 10 prime numbers: " + MathUtil.sumOfPrimes(10));
		System.out.println("Sum of first 20 prime numbers: " + MathUtil.sumOfPrimes(20));

		System.out.println("Sum of first 10 fibonacci numbers: " + MathUtil.sumOfFibonacci(10));
		System.out.println("Sum of first 20 fibonacci numbers: " + MathUtil.sumOfFibonacci(20));

		System.out.println("End of Advanced Calculator");
	}
}