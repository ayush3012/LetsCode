package DailyCheck_WarmUP.Array;

import java.util.Arrays;

public class CanJump45 {

    static void minJump(int[] nums)
    {
        int jump=0;
        int currentEnd=0;
        int farthest=0;
        for(int i=0;i< nums.length-1;i++)
        {
            farthest=Math.max(farthest,i+nums[i]);

            if(i==currentEnd)
            {
                jump++;
                currentEnd=farthest;
            }
        }
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++)
                if (dp[i] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[i] + 1);
        }
        return dp[nums.length - 1];
    }
    public static void main(String[] args) {
        int[] nums={2,3,0,1,4};

        minJump(nums);

        System.out.println(jump(nums));
    }
}
