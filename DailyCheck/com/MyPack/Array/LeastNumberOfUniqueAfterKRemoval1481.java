package DailyCheck.com.MyPack.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueAfterKRemoval1481 {

    static void remove(int[] arr,int k)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Map<Integer,Integer> hm=new HashMap<>();

        for(int a:arr) hm.put(a,hm.getOrDefault(a,0)+1);

        for(int a:hm.keySet()) pq.add(new int[]{a,hm.get(a)});

        while (k-->0)
        {
            int[] curr=pq.poll();
            curr[1]--;
            if(curr[1]>0)
                pq.add(curr);
        }
        System.out.println(pq.size());
    }
    public static void main(String[] args) {
        //int[] arr = {5,5,4};int k = 1;

        int[] arr = {4,3,1,1,3,3,2};int k = 3;

        remove(arr,k);
    }
}
