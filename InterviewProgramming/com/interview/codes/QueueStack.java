package com.interview.codes;

import java.util.Stack;

class Que{
	static Stack<Integer> stck1=new Stack<>();
	static Stack<Integer> stck2=new Stack<>();
	public static void push(int data)
	{
		while(!stck2.isEmpty())
			stck1.push(stck2.pop());
		stck1.push(data);
				
	}
	public static int pop()
	{
		while(!stck1.isEmpty())
			stck2.push(stck1.pop());
		return stck2.pop();
	}
}
public class QueueStack {
	

	public static void main(String[] args) {
		Que.push(1);
		Que.push(2);
		Que.push(3);
		System.out.println(Que.pop());
		Que.push(4);
		Que.push(5);
		System.out.println(Que.pop());

	}

}
