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
        boolean isCycle=false;
        while(fast!=null && fast.next!=null)  // detect cycle
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                isCycle=true;
                break;
            }
        }

        if(!isCycle)
        {
            System.out.println("no cycle");
            return;
        }
        slow=n;
        while (fast!=slow)
        {
            slow=slow.next;
            fast=fast.next;
        }
        Node start=slow;
        Node end=start;
        while (end.next!=start)
            end=end.next;
        //end.next=null //remove loop
        System.out.println("starting is: "+start.data);
        System.out.println("ending is: "+end.next);
    }
    static void loop2(Node n)
    {
        Node slow=n;
        Node fast=n;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                System.out.println("loop exists");
                slow=n;
                if(slow==fast)
                    while (fast.next!=slow)
                        fast=fast.next;
                else {
                    while (slow.next!=fast.next)
                    {
                        slow=slow.next;
                        fast=fast.next;
                    }
                }
                System.out.println("starts: "+fast.next.data+" end: "+fast.data);
                fast.next=null;
                System.out.println("loop removed");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,5,6,7,8,9};

        Node n=create(arr);

        //loop(n);

        loop2(n);

        display(n);
    }
}
