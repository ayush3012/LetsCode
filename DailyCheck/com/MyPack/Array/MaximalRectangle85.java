package DailyCheck.com.MyPack.Array;

import java.util.Stack;

public class MaximalRectangle85 {

    static int largestRectangle(int[] height)
    {
        int n= height.length;
        int[] l=new int[n];
        int[] r=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while (!stk.isEmpty() && height[stk.peek()]>height[i])
                stk.pop();
            l[i]=stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1;i>=0;i--)
        {
            while (!stk.isEmpty() && height[stk.peek()]>=height[i])
                stk.pop();
            r[i]=stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,(r[i]-l[i]-1)*height[i]);
        }
       return ans;
    }

    static void maximumRectangle(char[][] matrix)
    {
        int[] height=new int[matrix[0].length];
        int max=0;
        for (int i=0;i< matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                    height[j]++;
                else height[j]=0;
            }
            max=Math.max(max,largestRectangle(height));
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};

        maximumRectangle(matrix);
    }
}
