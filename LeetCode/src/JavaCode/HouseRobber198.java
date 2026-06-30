package LeetCode.src.JavaCode;

public class HouseRobber198 {

    static void robHouse(int[] nums)
    {
        if(nums.length==1)
        {
            System.out.println(nums[0]);
            return;
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],dp[1]);
        for(int i=2;i< nums.length;i++)
        {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        System.out.println(dp[nums.length-1]);
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,1};

        robHouse(nums);
    }
}
