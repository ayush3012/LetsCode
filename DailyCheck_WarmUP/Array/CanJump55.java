package DailyCheck_WarmUP.Array;

public class CanJump55 {

    static boolean canJump(int[] nums)
    {
        int max=0;
        for(int i=0;i< nums.length;i++)
        {
            if(i>max)
                return false;
            max=Math.max(max,i+nums[i]);
            if(max>= nums.length-1)
                return true;
        }
        return true;
    }
    public static boolean canJumpDP(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for(int i=0;i<nums.length;i++)
        {
            if(!dp[i])
                continue;
            for(int j=i+1;j<=Math.min(i+nums[i],nums.length-1);j++)
                dp[j]=true;
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {

        //int[] nums = {2,3,1,1,4};

        int[] nums = {3,2,1,0,4};

        System.out.println(canJump(nums));
    }
}
