package DailyCheck_WarmUP.Array;

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
    public static void main(String[] args) {
        int[] nums={2,3,0,1,4};

        minJump(nums);
    }
}
