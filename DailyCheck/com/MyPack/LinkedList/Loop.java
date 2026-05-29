package DailyCheck.com.MyPack.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Loop {
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

	static void removeLoop(Node n)
	{
		Node slow=n;
		Node fast=n;
		while (fast!=null && fast.next!=null)
		{
			if(slow.next==n)
			{
				System.out.println("loop detected");
				slow.next=null;
				System.out.println("loop removed");
				break;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
	}
	public void detectAndRemoveLoop(Node n)
	{
		Node tmp=n;
		Set<Node> hs=new HashSet<>();
		while(tmp!=null)
		{
			if(hs.contains(tmp.next))
			{
				System.out.println("\ncontains loop");
				tmp.next=null;   //breaking loop
			}
			hs.add(tmp);
			tmp=tmp.next;
		}
	}

	public static void main(String[] args) {
		
		Loop ll=new Loop();
		
		ll.display(head);
		
		tail.next=head.next.next.next.next;
		
		ll.detectAndRemoveLoop(head); System.out.println();
		
		ll.display(head);
		

	}

}
