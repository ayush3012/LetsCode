package DailyCheck.com.MyPack.Array;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature739 {

    static void monotonicStack(int[] temperatures)
    {
        int n= temperatures.length;;
        int[] res=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while (!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i])
            {
                int idx=stk.pop();
                res[idx]=i-idx;
            }
            stk.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {

        int[] temperatures={73,74,75,71,69,72,76,73};

        monotonicStack(temperatures);
    }
}
