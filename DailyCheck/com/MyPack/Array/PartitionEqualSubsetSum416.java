package DailyCheck.com.MyPack.Array;

public class PartitionEqualSubsetSum416 {

    static boolean canPartition(int[] nums)
    {
        int sum=0;
        for(int a:nums) sum+=a;
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int a:nums)
        {
            for(int i=target;i>=a;i--)
                dp[i]=dp[i] || dp[i-a];
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] nums={1,5,11,5};

        System.out.println(canPartition(nums));
    }
}
