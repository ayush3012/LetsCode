package DailyCheck.com.MyPack.LinkedList;

public class MergeTwoSortedList {

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
        for(int i=0;i<arr.length;i++)
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
    static Node merge(Node n1,Node n2)
    {
        Node dummy=new Node(-1);
        Node curr=dummy;
        while (n1!=null && n2!=null)
        {
            if(n1.data<n2.data)
            {
                curr.next=n1;
                n1=n1.next;
            }
            else {
                curr.next=n2;
                n2=n2.next;
            }
            curr=curr.next;
        }
        curr.next=n1==null?n2:n1;
        return dummy.next;
    }
    public static void main(String[] args) {

        int[] arr1={0,2,4,6,8};
        int[] arr2={1,3,5,7,9};

        Node n1=create(arr1);
        Node n2=create(arr2);

        display(n1);System.out.println();
        display(n2);System.out.println();

        Node m=merge(n1,n2);
        display(m);
    }
}
