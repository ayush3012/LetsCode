package com.mypack.Misc;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
	
	static int a=0;
	static int b=1;
	static int c=0;
	
	public static void FibonacciUsingIteration(int n)
	{
		int x=0;
		int y=1;
		int z=0;
		for(int i=0;i<n;i++)
		{
			z=x+y;
			x=y;
			y=z;
			System.out.print(" "+z+" ");
		}
	}

	public static void FibonacciUsingRecursion(int n)
	{
		if(n>0)
		{
			c=a+b;
			a=b;
			b=c;
			System.out.print(" "+c+" ");
			FibonacciUsingRecursion(n-1);
		}
		
	}
	public static int FibonacciRecursion(int n)
	{
		if(n<2)
			return n;
		return FibonacciRecursion(n-1)+FibonacciRecursion(n-2);
	}
	private static int pre=1;
	public static void FibonacciStream(int n)
	{
		IntStream.iterate(0,i->{i+=pre;pre=i-pre;return i;}).limit(n).forEach(i->System.out.print(i+" "));
	}
	public static void FibonacciStream_Alternate(int n)
	{
	 Stream.iterate(new int[] {0,1},f->new int[]{f[1],f[0]+f[1]}).map(i->i[0]).limit(n).forEach(i->System.out.print(i+" "));
	}
	public static void main(String[] args) {
		
		System.out.print(0+" "+1);
		FibonacciUsingIteration(10);
		
		System.out.println();
		System.out.print(0+" "+1);
		FibonacciUsingRecursion(10);
		
		System.out.println("\n=========");
		for(int i=0;i<12;i++)
			System.out.print(FibonacciRecursion(i)+" ");
		
		System.out.println("\n***********");
		FibonacciStream(10);
		
		System.out.println("\n***********");
		FibonacciStream_Alternate(10);
		
	}

}
