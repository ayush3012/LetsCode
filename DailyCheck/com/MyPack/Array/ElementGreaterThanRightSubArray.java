package com.mypack.Array;

import java.util.*;

public class ElementGreaterThanRightSubArray {
	
	public static void GreaterElement(int[] arr)
	{
		Stack<Integer> stk=new Stack<>();
		
		for(int a:arr)
		{
			if(!stk.isEmpty() && stk.peek()<a)
				stk.pop();
			stk.push(a);
		}
		Iterator<Integer> it=stk.iterator();
		while(it.hasNext())
			System.out.println(it.next()+" ");
	}

	/*
	* Below method will work efficiently.
	* Above method can fail for different inputs like int[] arr= {10,4,1,2,5};
	* */
	static void GreaterThanRightSubarray(int[] arr)
	{
		List<Integer> al=new ArrayList<>();
		int max=arr[arr.length-1];
		al.add(max);
		for(int i=arr.length-2;i>=0;i--)
		{
			if(arr[i]>max)
			{
				max=arr[i];
				al.add(max);
			}
		}
		Collections.reverse(al);
		al.stream().forEach(i-> System.out.print(i+" "));
	}

	public static void main(String[] args) {
		
		int[] arr= {10,4,1,2,5};
		
		//GreaterElement(arr);

		GreaterThanRightSubarray(arr);

	}

}
