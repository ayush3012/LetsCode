package DailyCheck.com.MyPack.LinkedList;

public class ReverseBetweenSpecificNode92 extends BasicOperation{

    static Node reverse(Node n,int left,int right)
    {
        if(n==null || left==right) return n;
        Node dummy=new Node(-1);
        dummy.next=n;
        Node prev=dummy;
        for(int i=1;i<left;i++)
            prev=prev.next;
        Node curr= prev.next;
        Node pre=null;
        for(int i=left;i<=right;i++)
        {
            Node after=curr.next;
            curr.next=pre;
            pre=curr;
            curr=after;
        }
        Node start=prev.next;
        prev.next=pre;
        start.next=curr;
       return dummy.next;
    }
    public static void main(String[] args) {

        int[] arr={1,2,3,4,5};

    }
}
