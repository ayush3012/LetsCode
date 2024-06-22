package com.mypack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighest {
	
	public static int SecondMax(int[] arr)
	{
		int max=Integer.MIN_VALUE;
		int smax=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				smax=max;
				max=arr[i];
			}
			else if(max>smax && arr[i]>smax)
				smax=arr[i];
		}
		return smax;
	}

	public static void SecondHeighestStream(int[] arr)
	{
		int a=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(a);
		
		List<Integer> al=new ArrayList<>();
		for(int i:arr)
			al.add(i);
		int t=al.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println(t);
	}
	public static void main(String[] args) {
		
		int[] arr= {3,9,1,12,5,11,15};
		
		System.out.println(SecondMax(arr));
		
		SecondHeighestStream(arr);
	}

}
