package LeetCode.src.JavaCode;

public class HouseRobber213 {

    static void robHouseInCircle(int[] nums)
    {
        if(nums.length==1)
        {
            System.out.println(nums[0]);
            return;
        }
        int max=Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));
        System.out.println(max);
    }
    static int helper(int[] nums,int start,int end)
    {
        if(start==end)
            return nums[start];
        int[] dp=new int[nums.length];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<=end-start;i++)
            dp[i]=Math.max(nums[start+i]+dp[i-2],dp[i-1]);
        return dp[end-start];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        robHouseInCircle(nums);
    }
}
