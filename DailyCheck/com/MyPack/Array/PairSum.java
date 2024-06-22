package com.mypack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {
	
	public static void method1(int[] arr,int k)
	{
		List<Integer> al=new ArrayList<>();
		int count=0;
		for(int i:arr)
		{
			if(al.contains(k-i))
			{
				System.out.println("found sum "+i+" and "+(k-i));
				count++;
			}
			al.add(i);
		}
		System.out.println("total pairs: "+count);
	}

	public static void method2(int[] arr,int k)
	{
		Arrays.sort(arr);
		int s=0;
		int e=arr.length-1;
		int count=0;
		while(s<e)
		{
			if(arr[s]+arr[e]==k)
			{
				System.out.println("sum found at "+s+" "+e);
				s++;
				e--;
				count++;
			}
			else if(arr[s]+arr[e]>k)
			{
				e--;
			}
			else if(arr[s]+arr[e]<k)
			{
				s++;
			}
		}
		System.out.println("total pairs: "+count);
	}
	public static void main(String[] args) {
		
		int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        method1(arr,sum);System.out.println();
        method2(arr, sum);

	}

}
