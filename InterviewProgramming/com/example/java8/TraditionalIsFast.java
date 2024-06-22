package com.example.java8;

import java.util.ArrayList;
import java.util.List;

public class TraditionalIsFast {

	/*
	 * order of speed:: Traditional> parallel stream>stream 
	 * explanation:The good old
	 * loop over primitive type such as int[] are faster because you have direct
	 * access to an indexed memory structure. Also compilers are very efficient in
	 * optimizing these operations.
	 * 
	 * Streams implementation depend on Data Structures such as List, ArrayList,
	 * which then requires the use of iterators and don't forget the boxing &
	 * unboxing to & from primitive types <-> Object.
	 * 
	 * If you run your test not using int[] but ArrayList, you might get a closer
	 * result.
	 */
	public static void main(String[] args)
	{
		List<Integer> al=new ArrayList<>(100);
		for(int i=0;i<100;i++)
			al.add(Integer.valueOf(i));
		long s=System.currentTimeMillis();
		for(int i:al)
			System.out.print(i);
		long e=System.currentTimeMillis();
		System.out.println("time taken "+(e-s));
		System.out.println("***************");
		long s2=System.currentTimeMillis();
		al.stream().forEach(i->System.out.print(i));
		long e2=System.currentTimeMillis();
		System.out.println("time taken "+(e2-s2));
		System.out.println("***************");
		long s3=System.currentTimeMillis();
		al.parallelStream().forEach(i->System.out.print(i));
		long e3=System.currentTimeMillis();
		System.out.println("time taken "+(e3-s3));
	}
}
