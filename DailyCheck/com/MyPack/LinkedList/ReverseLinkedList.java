package com.mypack.LinkedList;

public class ReverseLinkedList extends BasicOperation {
	
	private static Node head,tail=null;
	static {
		for(int i=1;i<10;i++)
		{
			Node n=new Node(i);
		    if(head==null)
			  head=tail=n;
		    else
		    {
		    	tail.next=n;
		    	tail=n;
		    }
		}
		
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
	public Node Reverse(Node n)
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

	public Node ReverseByK(Node n,int k)
	{
		Node pre=null;
		Node curr=n;
		Node after=null;
		int count=0;
		while(count<k && curr!=null)
		{
			after=curr.next;
			curr.next=pre;
			pre=curr;
			curr=after;
			count++;
		}
		if(after!=null)
			n.next=ReverseByK(after, k);
		return pre;
	}
	public Node ReverseAlternateByK(Node n,int k)
	{
		Node pre=null;
		Node curr=n;
		Node after=null;
		int count=0;
		while(count<k && curr!=null)
		{
			after=curr.next;
			curr.next=pre;
			pre=curr;
			curr=after;
			count++;
		}
		if(n!=null)
			n.next=curr;
		count=0;
		while(count++<k-1 && curr!=null)
			curr=curr.next;
		
		if(curr!=null)
			curr.next=ReverseAlternateByK(curr.next, k);
		return pre;
	}
	public static void main(String[] args) {
		
		ReverseLinkedList ll1=new ReverseLinkedList();
		
		ll1.display(head);
		
		//Node tmp=ll1.Reverse(head); System.out.println();
		
		//ll1.display(tmp);
		
		//Node tmpK=ll1.ReverseByK(head, 3); System.out.println();
		
		//ll1.display(tmpK);
		
		Node tmpAlternateK=ll1.ReverseAlternateByK(head, 3); System.out.println();
		
		ll1.display(tmpAlternateK);
		
	}

}
