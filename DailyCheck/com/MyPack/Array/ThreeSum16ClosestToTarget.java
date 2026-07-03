package DailyCheck.com.MyPack.Array;

import java.util.Arrays;

public class ThreeSum16ClosestToTarget {

    static void AdvanceThreeSum(int[] nums,int target)
    {
        Arrays.sort(nums);
        int res=0;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i-1]==nums[i])
                continue;
            int j=i+1,k=nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    res = sum;
                }
                if (sum > target)
                    k--;
                else if (sum < target)
                    j++;
                else break;
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int[] nums={ -1,2,1,-4};int target=1;
        AdvanceThreeSum(nums,target);
    }
}
