package DailyCheck.com.MyPack.Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax239 {

    static void code(int[] nums,int k)
    {
        Deque<Integer> dq=new ArrayDeque<>();           // deque stores index
        int[] res=new int[nums.length-k+1];
        int r=0;
        for(int i=0;i<nums.length;i++)
        {
            while (!dq.isEmpty() && dq.peekFirst()<=i-k)     // peekFirst:index of head
                dq.removeFirst();                            // remove first index
            while (!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.removeLast();
            dq.addLast(i);
            if(i>=k-1)
                res[r++]=nums[dq.peekFirst()];

        }
        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {
        int[] nums={1,-1};int  k=1;

        code(nums,k);
    }
}
