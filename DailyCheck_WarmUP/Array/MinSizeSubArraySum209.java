package DailyCheck_WarmUP.Array;

public class MinSizeSubArraySum209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE,sum=0,left=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(sum>=target)
            {
                sum-=nums[left++];
                if(sum<target)
                    min=Math.min(min,i-(left-2));
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    public static void main(String[] args) {

        int[] nums ={1,4,4};int target=4;

        System.out.println(minSubArrayLen(target,nums));
    }
}
