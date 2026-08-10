package DailyCheck.com.MyPack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairsSum373 {

    static void KSmallestPairSum(int[] nums1,int[] nums2,int k)
    {
        List<List<Integer>> res=new ArrayList<>();

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->
                Integer.compare(nums1[a[0]]+nums2[a[1]],nums1[b[0]]+nums2[b[1]]));

        for(int i=0;i<nums1.length;i++)
            pq.add(new int[]{i,0});

        while(k-->0)
        {
            int[] curr=pq.poll();

            res.add(Arrays.asList(nums1[curr[0]],nums2[curr[1]]));

            if(curr[1]+1<nums2.length)
                pq.add(new int[]{curr[0],1+curr[1]});
        }
        res.forEach(i-> System.out.println(i));
    }
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};   int k = 3;

        KSmallestPairSum(nums1,nums2,k);
    }
}
