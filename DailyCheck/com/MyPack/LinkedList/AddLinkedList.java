package com.mypack.LinkedList;

import java.util.Random;

public class AddLinkedList {
	
	private static Node head1 , tail1=null;
	private static Node head2,tail2=null;
	
	private static Node head3,tail3=null;
	
	static {
		Random r=new Random();
		int n1=r.nextInt(5);
		int n2=r.nextInt(5);
		for(int i=0;i<n1;i++)
		{
			Node n=new Node(r.nextInt(10));
			if(head1==null)
				head1=tail1=n;
			else
			{
				tail1.next=n;
				tail1=n;
			}
		}
		for(int i=0;i<n2;i++)
		{
			Node n=new Node(r.nextInt(10));
			if(head2==null)
				head2=tail2=n;
			else
			{
				tail2.next=n;
				tail2=n;
			}
		}
	}

	public void display(Node n)
	{
		Node tmp=n;
		while(tmp!=null)
		{
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
	}
	private Node rev(Node n)
	{
		Node pre=null;
		Node curr=n;
		Node after=null;
		while(curr!=null)
		{
			after=curr.next;
			curr.next=pre;
			pre=curr;
			curr=after;
		}
		return pre;
	}
	public void Add(Node n1,Node n2)
	{
		Node n1r=rev(n1);
		Node n2r=rev(n2);
		int sum=0;
		while(n1r!=null && n2r!=null)
		{
			int x=(n1r.data+n2r.data+sum);
			 sum=x%10;
			 createList(new Node(sum));
			 sum=x/10;
			 n1r=n1r.next;
			 n2r=n2r.next;
		}
		while(n1r!=null)
		{
			int x=(n1r.data+sum);
			sum=x%10;
			 createList(new Node(sum));
			 sum=x/10;
			 n1r=n1r.next;
		}
		while(n2r!=null)
		{
			int x=(n2r.data+sum);
			sum=x%10;
			 createList(new Node(sum));
			 sum=x/10;
			 n2r=n2r.next;
		}
		if(sum==1)
		{
			Node n=new Node(1);
			tail3.next=n;
			tail3=n;
		}
	}
	public void createList(Node n)
	{
		if(head3==null)
			head3=tail3=n;
		else
		{
			tail3.next=n;
			tail3=n;
		}
	}
	public static void main(String[] args) {
		
		AddLinkedList ll=new AddLinkedList();
		
		ll.display(head1);
		
		System.out.println();
		
		
		ll.display(head2);
		
		System.out.println();
		
		ll.Add(head1,head2);
		
		head3=ll.rev(head3);
		
		ll.display(head3);

	}

}
