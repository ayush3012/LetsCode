package com.mypack.Misc;

import java.util.Iterator;
import java.util.Stack;

public class ReverseStackRecursion {
	
	public static void insertBottom(Stack<Integer> stk,int k)
	{
		if(stk.isEmpty())
			stk.push(k);
		else
		{
			int a=stk.pop();
			insertBottom(stk, k);
			stk.push(a);
		}
			
	}
	
	public static void reverse(Stack<Integer> stk)
	{
		if(stk.size()==0)
			return;
		else
		{
			int a=stk.pop();
			reverse(stk);
			insertBottom(stk,a);
		}
	}

	public static void main(String[] args) {
		
		Stack<Integer> stk=new Stack<>();
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.push(6);
		
		Iterator<Integer> itr=stk.iterator();
		
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
		
		System.out.println();
		
		reverse(stk);
		
        Iterator<Integer> itr2=stk.iterator();
		
		while(itr2.hasNext())
			System.out.print(itr2.next()+" ");
	}

}
