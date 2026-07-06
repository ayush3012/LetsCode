package DailyCheck.com.MyPack.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStoneToMinimizeTotal1962 {

    static void minimize(int[] nums,int k)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int a:nums) pq.add(a);
        while (k-->0)
        {
            int x=pq.poll();
            int y=(int)(Math.ceil((double) x/2));
            pq.add(y);
        }
        int sum=0;
        while (!pq.isEmpty())
            sum+=pq.poll();
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int[] nums={5,4,9};
        int k=2;
        minimize(nums,k);
    }
}
