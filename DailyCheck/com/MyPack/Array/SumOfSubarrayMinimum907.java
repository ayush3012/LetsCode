package DailyCheck.com.MyPack.Array;

import java.util.Stack;

public class SumOfSubarrayMinimum907 {

    static void subArrayMinSum(int[] arr)
    {
        final int MOD=1000000007;
        Stack<Integer> stk=new Stack<>();
        int n=arr.length;
        int[] l=new int[n];
        int[] r=new int[n];
        for(int i=0;i<n;i++)
        {
            while (!stk.isEmpty() && arr[stk.peek()]>arr[i])
                stk.pop();
            l[i]=stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        stk.clear();
        for (int i=n-1;i>=0;i--)
        {
            while (!stk.isEmpty() && arr[stk.peek()]>=arr[i])
                stk.pop();
            r[i]=stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++)
        {
            long left=i-l[i];
            long right=r[i]-i;
            ans=(ans+arr[i]*left*right)%MOD;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {

        int[] arr = {11,81,94,43,3};

        subArrayMinSum(arr);
    }
}
