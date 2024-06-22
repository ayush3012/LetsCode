package com.example.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* parallel stream divide the data structure in chunks and provide it to separate thread 
 * in fork-join common pool thread.
 * 
 * number of thread in fork join pool=number of processor available in machine.
 * 
 * 
 * so all are divided into different processor and result is again combined and send back
 * 
 * it is not mandatory that parallel stream will take less time than sequential stream.  
 * 
 * 
 */
public class DisadvantageOfParallelStream {
	
	public static void sequentialStream(List<Integer> al)
	{
		long s=System.currentTimeMillis();
		al.stream().reduce(0,(a,b)->a+b);
		long duration =System.currentTimeMillis()-s;
		System.out.println("execution time in sequential stream "+duration);
	}
	public static void parallelStream(List<Integer> al)
	{
		long s=System.currentTimeMillis();
		al.stream()
		.parallel()
		.reduce(0,(a,b)->a+b);// here require unboxing and that is taking time
		long duration =System.currentTimeMillis()-s;
		System.out.println("execution time in parallel stream "+duration);
	}

	public static void main(String[] args) {
		
		List<Integer> al=IntStream.rangeClosed(0,10000).boxed().collect(Collectors.toList());
		
		sequentialStream(al);
		
		parallelStream(al);
		
		System.out.println("======example 2======");
		
		IntStream.rangeClosed(0,1000).forEach(Sum::calculateSum);
		
		System.out.println("sum in sequential stream "+Sum.getTotal());
		
       IntStream.rangeClosed(0,1000).parallel().forEach(Sum::calculateSum);
		
		System.out.println("sum in sequential stream "+Sum.getTotal());
		
	}

}

class Sum{
	
	private static int total; // because total is mutable thats why we are getting random number
	
	public static int getTotal()
	{
		return total;
	}
	
	public static void calculateSum(int input)
	{
		total+=input;
	}
}
