package DailyCheck.com.MyPack.Array;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement503 {
    static public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stk = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--)
        {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i % n])
                stk.pop();

            if (i < n && !stk.isEmpty())
                res[i] = nums[stk.peek()];
            stk.push(i % n);
        }
        return res;
    }

    public int[] nextGreaterElements_mySolution(int[] nums) {
        int[] res=new int[nums.length];
        Stack<Integer> stk=new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            int j=i;
            int n=0;
            while (nums[j% nums.length]<=nums[i])
            {
                j++;n++;
                if(n==nums.length)
                {
                    n=0;
                    break;
                }
            }
            while(!stk.isEmpty() && stk.peek()<=nums[i])
                stk.pop();
            res[i]=!stk.isEmpty()?stk.peek():(n!=0?nums[j% nums.length]:-1);
            stk.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
