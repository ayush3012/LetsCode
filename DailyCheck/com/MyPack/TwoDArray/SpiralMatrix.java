package DailyCheck.com.MyPack.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    static void code(int[][] matrix)
    {
        List<Integer> res=new ArrayList<>();
        int top=0;
        int bottom= matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while (top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i++)
                res.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bottom;i++)
                res.add(matrix[i][right]);
            right--;
            if(top<=bottom)
            {
                for (int i=right;i>=left;i--)
                    res.add(matrix[bottom][i]);
                bottom--;
            }
            if(left<=right)
            {
                for (int i=bottom;i>=top;i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        res.forEach(i-> System.out.print(i+" "));
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9,10,11,12}};

        code(matrix);
    }
}
