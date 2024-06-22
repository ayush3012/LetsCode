package com.mypack.Array;

import java.util.Iterator;
import java.util.Stack;

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

	public static void main(String[] args) {
		
		int[] arr= {10,4,6,3,5};
		
		GreaterElement(arr);

	}

}
