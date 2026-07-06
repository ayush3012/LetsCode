package DailyCheck.com.MyPack.LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList23 extends BasicOperation{

    static Node merge(Node[] list)
    {
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.data-b.data);

        for(Node n:list)
        {
            if(n!=null)
                pq.offer(n);
        }
        Node dummy=new Node(-1);
        Node tail=dummy;
        while (!pq.isEmpty())
        {
            Node curr=pq.poll();
            tail.next=curr;
            tail=tail.next;
            if(curr.next!=null)
                pq.offer(curr.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        //Node[] list= {{1,4,5},{1,3,4},{2,6}};
    }
}
