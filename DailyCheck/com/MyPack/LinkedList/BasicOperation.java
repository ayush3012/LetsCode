package com.mypack.LinkedList;

public class BasicOperation {
	
	private  Node head,tail=null;
	
	 void push(int data)
	{
		Node n=new Node(data);
		if(head==null)
			head=tail=n;
		else
		{
			tail.next=n;
			tail=n;
		}
	}

	 void delete(int data)
	{
		Node tmp=head;
		while(tmp.next.data!=data)
			tmp=tmp.next;
		tmp.next=tmp.next.next;
	}
	
	 void display(Node n)
	{
		Node tmp=n;
		while(tmp!=null)
		{
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
	}
	public static void main(String[] args) {
		
		BasicOperation linkedList=new BasicOperation();
		
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.push(5);
		linkedList.push(6);
		linkedList.push(7);
		linkedList.push(8);
		
		linkedList.display(linkedList.head);
		
		linkedList.delete(5);  System.out.println();
		
		linkedList.display(linkedList.head);
		
		
	}

}
