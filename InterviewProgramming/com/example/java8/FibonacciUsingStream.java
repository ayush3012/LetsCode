package com.example.java8;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FibonacciUsingStream {
	
	private static int prev=1;
	private static void FibonacciStream(int x)
	{
		IntStream.iterate(0, n->{n+=prev;prev=n-prev;return n;}).limit(x).forEach(i->System.out.print(i+" "));
	}

	public static int fib(int x)
	{
		return x<2?x:fib(x-1)+fib(x-2);
	}
	public static void main(String[] args) {
		
		FibonacciStream(10);
	}

}
