package DailyCheck.com.MyPack.Array;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement503 {
    static public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stk = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int curr = nums[i % n];

            while (!stk.isEmpty() && nums[stk.peek()] <= curr) {
                stk.pop();
            }

            if (i < n && !stk.isEmpty()) {
                res[i] = nums[stk.peek()];
            }

            stk.push(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
