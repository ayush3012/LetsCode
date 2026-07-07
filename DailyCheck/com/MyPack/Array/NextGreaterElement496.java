package DailyCheck.com.MyPack.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement496 {

    static void monotonicStack(int[] nums1,int[] nums2)
    {
        int[] res=new int[nums1.length];
        Map<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> stk=new Stack<>();
        for(int a:nums2)
        {
            while (!stk.isEmpty() && a>stk.peek())
                hm.put(stk.pop(),a);
            stk.push(a);
        }
        while (!stk.isEmpty()) hm.put(stk.pop(),-1);
        for(int i=0;i<nums1.length;i++)
            res[i]=hm.get(nums1[i]);

        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {

        int[] nums1 = {2,4};int[] nums2 = {1,2,3,4};

        monotonicStack(nums1,nums2);
    }
}
