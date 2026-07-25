package DailyCheck_WarmUP.Array;

public class MaxProductSubArray152 {

    static int maxProduct(int[] nums)
    {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i< nums.length;i++)
        {
            if(nums[i]<0)
                max=max+min-(min=max);
            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);
            ans=Math.max(max,ans);
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums={2,3,-2,4};

        System.out.println(maxProduct(nums));
    }
}
