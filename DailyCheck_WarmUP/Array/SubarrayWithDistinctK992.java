package DailyCheck_WarmUP.Array;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithDistinctK992 {

    private static int atMost(int[] nums,int k)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        int l=0,count=0;
        for(int i=0;i< nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            while (hm.size()>k)
            {
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0)
                    hm.remove(nums[l]);
                l++;
            }
            count+=i-l+1;
        }
        return count;
    }
    public static int subarraysWithKDistinct(int[] nums,int k)
    {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};int k = 2;
        //int[] nums = {1,2,1,3,4};int k = 3;

        System.out.println(subarraysWithKDistinct(nums,k));

    }
}
