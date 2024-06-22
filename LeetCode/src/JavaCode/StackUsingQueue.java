package JavaCode;

import java.util.LinkedList;
import java.util.Queue;

class Stack{
	
	private static Queue<Integer> q1;
	private static Queue<Integer> q2;
	Stack()
	{
		q1=new LinkedList<>();
		q2=new LinkedList<>();
	}
	public void push(int x)
	{
		q2.add(x);
		while(!q1.isEmpty())
			q2.add(q1.poll());
		Queue<Integer> q=q1;
		q1=q2;
		q2=q;
	}
	public int pop()
	{
		if(q1.isEmpty())
			throw new ArithmeticException();
		return q1.poll();
	}
	public boolean isEmpty()
	{
		return q1.isEmpty();
	}
	public int top()
	{
		if(q1.isEmpty())
			return -1;
		return q1.peek();
	}
}	
	
public class StackUsingQueue {

	public static void main(String[] args) 
	{
		
	}

}
