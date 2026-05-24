package DailyCheck.com.MyPack.LinkedList;


public class RemoveDuplicate {

    static Node create(int[] arr)
    {
        Node head=null;
        Node tail=null;
        for(int i=0;i<arr.length;i++)
        {
            Node tmp=new Node(arr[i]);
            if(head==null)
                head=tail=tmp;
            else {
                tail.next=tmp;
                tail=tmp;
            }
        }
        return head;
    }

    static void display(Node n)
    {
        Node tmp=n;
        while (tmp!=null)
        {
            System.out.print(tmp.data+" ");
            tmp=tmp.next;
        }
    }

    static void remove(Node n)
    {
        Node curr=n;
        while (curr!=null)
        {
            Node tmp=curr;
            while (tmp.next!=null)
            {
                if(tmp.next.data==curr.data)
                    tmp.next=tmp.next.next;
                else tmp=tmp.next;
            }
            curr=curr.next;
        }
    }
    public static void main(String[] args)
    {
        int[] arr={1,2,3,3,4,4,5};

        Node n=create(arr);

        display(n);
        System.out.println();
        remove(n);

        display(n);

    }
}
