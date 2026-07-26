package DailyCheck_WarmUP.Array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum523 {

    static boolean checkSubArray(int[] nums,int k)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            int rem=sum%k;
            if(hm.containsKey(rem) && i-hm.get(rem)>=2)
                return true;
            hm.putIfAbsent(rem,i);   //Think here , why putIfAbsent?
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums={5,0,0,0};int k=3;

        System.out.println(checkSubArray(nums,k));
    }
}
