package DailyCheck.com.MyPack.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {

    static void zeroSum(int[] arr)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
                max=Math.max(max,i-hm.get(sum));
            else hm.put(sum,i);
        }
        System.out.println("Max Length:"+max);
    }
    public static void main(String[] args) {
        int[] arr={1,0,2,-1,-1,-1,0,1,-1};

        zeroSum(arr);
    }
}
