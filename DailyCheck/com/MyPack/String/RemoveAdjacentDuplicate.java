package com.mypack.String;

import java.util.Iterator;
import java.util.Stack;

public class RemoveAdjacentDuplicate {
	
	public static void RemoveDuplicate(String str)
	{
		Stack<Character> stk=new Stack<>();
		String res="";
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(!stk.isEmpty() && stk.peek()==ch)
				stk.pop();
			else
				stk.push(ch);
		}
		Iterator<Character> itr=stk.iterator();
		while(itr.hasNext())
			res+=itr.next();
		
		System.out.println(res);
	}

	public static void main(String[] args) {
		
		String str="azxxzy";
		
		RemoveDuplicate(str);
		
	}

}
