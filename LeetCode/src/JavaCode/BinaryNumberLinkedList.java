package JavaCode;


public class BinaryNumberLinkedList {
	static class Node{
		int data;
		Node next;
	}
	
	 Node head;
	
	//convert binary number represented by linkedlist to decimal
	public static int BinaryNumber(Node head)
	{
		Node temp=head;
		int len=0;
		while(temp!=null)
		{
			len++;
			temp=temp.next;
		}
		int sum=0;
		while(head!=null)
		{
			sum+=(head.data)*Math.pow(2,--len);
			head=head.next;
		}
		return sum;
	}

	public static void main(String[] args) {
		
	
	}

}
