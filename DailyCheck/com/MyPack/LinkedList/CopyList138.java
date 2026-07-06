package DailyCheck.com.MyPack.LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node1{

    int data;
    Node1 next;
    Node1 random;
    Node1(int data)
    {
        this.data=data;
        this.next=null;
        this.random=null;
    }
}
public class CopyList138 {

    static Node1 copyWithRandomPointer(Node1 head)
    {
       Map<Node1,Node1> hm=new HashMap<>();
       Node1 curr=head;
       while (curr!=null)
       {
           hm.put(curr,new Node1(curr.data));
           curr=curr.next;
       }
       curr=head;
       while (curr!=null)
       {
           Node1 copy=hm.get(curr);
           copy.next=hm.get(curr.next);
           copy.random=hm.get(curr.random);
           curr=curr.next;
       }
       return hm.get(head);
    }

    public static void main(String[] args) {

    }
}
