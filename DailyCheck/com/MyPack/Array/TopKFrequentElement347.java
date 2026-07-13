package DailyCheck.com.MyPack.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement347 {

    static void frequentElement(int[] arr,int k)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int a:arr) hm.put(a,hm.getOrDefault(a,0)+1);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int x:hm.keySet())
        {
            pq.offer(new int[]{x,hm.get(x)});
            if(pq.size()>k)
                pq.poll();
        }
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--)
            res[i]=pq.poll()[0];
        System.out.println(Arrays.toString(res));

    }

    public static void main(String[] args) {

        int[] nums={1,1,1,2,2,3};
        int k=2;

        frequentElement(nums,k);
    }
}
