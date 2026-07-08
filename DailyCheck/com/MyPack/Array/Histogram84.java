package DailyCheck.com.MyPack.Array;

import java.util.Stack;

public class Histogram84 {

    static void histogram(int[] heights)
    {
        Stack<Integer> stk=new Stack<>();
        int max=0;
        int[] l=new int[heights.length];
        int[] r=new int[heights.length];
        for(int i=0;i<heights.length;i++)
        {
            while (!stk.isEmpty() && heights[stk.peek()]>=heights[i])
                stk.pop();
            l[i]=stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        while (!stk.isEmpty()) stk.pop();

        for(int i=heights.length-1;i>=0;i--)
        {
            while (!stk.isEmpty() && heights[stk.peek()]>=heights[i])
                stk.pop();
            r[i]=stk.isEmpty()?heights.length:stk.peek();
            stk.push(i);
        }
        for(int i=0;i<heights.length;i++)
        {
            max=Math.max(max,(r[i]-l[i]-1)*heights[i]);
        }
        System.out.println(max);
    }
    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        //int[] heights = {2,4};

        histogram(heights);
    }
}
