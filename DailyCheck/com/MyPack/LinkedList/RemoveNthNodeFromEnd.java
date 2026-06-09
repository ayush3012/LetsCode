package DailyCheck.com.MyPack.LinkedList;

public class RemoveNthNodeFromEnd {

    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
    }

    static Node create(int[] arr)
    {
        Node head=null,tail=null;
        for(int i=0;i< arr.length;i++)
        {
            Node n=new Node(arr[i]);
            if(head==null)
                head=tail=n;
            else {
                tail.next=n;
                tail=n;
            }
        }
        return head;
    }

    static void display(Node n)
    {
        Node temp=n;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    static Node RemoveNthNode(Node n,int k)
    {
        Node dummy=new Node(-1);
        dummy.next=n;
        Node slow=dummy;
        Node fast=dummy;
        for(int i=0;i<=k;i++)
            fast=fast.next;
        while (fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {

        int[] arr={0,1,2,3,4,5,6,7,8,9};

        Node n=create(arr);
        display(n);
        System.out.println();
        Node r=RemoveNthNode(n,2);
        display(r);
    }
}
