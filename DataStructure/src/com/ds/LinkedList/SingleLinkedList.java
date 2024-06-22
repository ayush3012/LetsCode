package com.ds.linkedlist;

import java.util.HashSet;

class Node{
	
	int data;
	Node next;
	public Node(int d)
	{
		this.data=d;
		this.next=null;
	}
}
public class SingleLinkedList {
	Node head;
	public void push(int d)
	{
		Node n=new Node(d);
		n.next=head;
		head=n;
	}
	public void insert(Node n,int d)
	{
		Node e=new Node(d);
		Node temp=head;
		while(temp!=n)
		{
			temp=temp.next;
		}
		e.next=temp.next;
		temp.next=e;		
	}
	public void append(int d)
	{
		Node temp=head;
		while(temp.next!=null)
			temp=temp.next;
		Node n=new Node(d);
		temp.next=n;
	}
	public void print()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public void delete(Node n)
	{
		Node temp=head;
		while(temp.next!=n)
			temp=temp.next;
		temp.next=temp.next.next;
	}
	public void printMiddle()
	{
		Node temp1=head;
		Node temp2=head;
		while(temp2!=null && temp2.next!=null)
		{
			temp1=temp1.next;
			temp2=temp2.next.next;
		}
		System.out.println(temp1.data);
	}
	public boolean removeLoopSet()
	{
		HashSet<Node> hs=new HashSet<>();
		Node prev=null;
		Node temp=head;
		while(temp!=null)
		{
			if(!hs.contains(temp))
			{
				hs.add(temp);
				prev=temp;
				temp=temp.next;
			}
			else
			{
				prev.next=null;
				return true;
			}
		}
		return false;				
	}

	public void ReversePrint(Node t)
	{
		if(t==null)
			return;
		ReversePrint(t.next);
		System.out.print(t.data+" ");
	}
	public Node ReverseListKNode(Node h,int k)
	{
		Node curr=h;
		Node after=null;
		Node before=null;
		int count=0;
		while(count<k && curr!=null)
		{
			after=curr.next;
			curr.next=before;
			before=curr;
			curr=after;
			count++;
		}
		if(after!=null)
			head.next=ReverseListKNode(after,k);
		return before;
	}
	public static void main(String[] args) 
	{
		SingleLinkedList sll=new SingleLinkedList();
		sll.push(6);
		sll.print();
		sll.append(0);
		sll.append(3);
		sll.append(8);
		sll.print();
		sll.insert(sll.head.next.next, 9);
		sll.print();
		sll.append(12);
		sll.print();
		//sll.delete(sll.head.next.next.next.next);
		sll.print();
		sll.printMiddle();
		sll.head.next.next.next.next.next.next=sll.head.next.next;
		System.out.println(sll.removeLoopSet());
		sll.print();
		sll.ReversePrint(sll.head);
		Node temp=sll.ReverseListKNode(sll.head,3);
		System.out.println();
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

}
