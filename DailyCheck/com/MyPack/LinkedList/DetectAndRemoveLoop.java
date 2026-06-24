package DailyCheck.com.MyPack.LinkedList;

public class DetectAndRemoveLoop {

    static Node create(int[] arr)
    {
        Node head=null,tail=null;
        for(int a:arr)
        {
            Node n=new Node(a);
            if(head==null)
                head=tail=n;
            else{
                tail.next=n;
                tail=n;
            }
        }
        // make cycle here
        tail.next=head.next.next.next;
        return head;
    }
    static void display(Node n)
    {
        Node temp=n;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static void loop(Node n)
    {
        Node slow=n,fast=n;
        while(fast!=null && fast.next!=null)  // detect cycle
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }

        if(fast==null || fast.next==null)    // no cycle
        {
            System.out.println("\nNo cycle");
            return;
        }

        slow=n;
        while (slow!=fast)     //start of the cycle
        {
            slow=slow.next;
            fast=fast.next;
        }

        Node start=slow;
        Node end=start;
        while (end.next!=start)
            end=end.next;

        while(fast.next!=slow)    //last of the node
            fast=fast.next;

        fast.next=null;     // removed loop

        System.out.println("start :"+start.data);
        System.out.println("end : "+end.data);

    }
    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,5,6,7,8,9};

        Node n=create(arr);

        loop(n);

        display(n);
    }
}
