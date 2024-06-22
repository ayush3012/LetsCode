package com.mypack.Array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
	
	public static void method1(int[] arr)
	{
		Set<Integer> set=new HashSet<>();
		for(int i:arr)
			set.add(i);
		int[] arr2=new int[set.size()];
		int i=0;
		for(Integer p:set)
			arr2[i++]=p;
		for(int o:arr2)
			System.out.print(o+" ");
	}
	
	public static void method2(int[] arr)
	{
		int j=0;
		for(int i=0;i<arr.length-1;i++)
			if(arr[i]!=arr[i+1])     //replace arr[i+1] to tar to replace only tar element
				arr[j++]=arr[i];
		arr[j++]=arr[arr.length-1];
		for(int i=0;i<j;i++)
			System.out.print(arr[i]+" ");
	}

	public static void main(String[] args) {
		
		int[] arr= {1,2,3,3,4,5,5};
		
		method1(arr);
		
		System.out.println();
		
		method2(arr);
	}

}
