package DailyCheck.com.MyPack.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow417 {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res=new ArrayList<>();
        boolean[][] pacific=new boolean[heights.length][heights[0].length];
        boolean[][] atlantic=new boolean[heights.length][heights[0].length];

        for(int i=0;i<heights.length;i++)
        {
            mark(i,0,pacific,-1,-1,heights);
            mark(i, heights[0].length-1,atlantic,-1,-1,heights);
        }

        for(int i=0;i<heights[0].length;i++)
        {
            mark(0,i,pacific,-1,-1,heights);
            mark(heights.length-1, i,atlantic,-1,-1,heights);
        }
        for(int i=0;i< heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    static void mark(int i,int j,boolean[][] arr,int oi,int oj,int[][] heights)
    {
        if(i<0 || i>= heights.length || j<0 || j>=heights[0].length || arr[i][j]
                || (oi>=0 && oj>=0 && heights[oi][oj]>heights[i][j]))
            return;
        arr[i][j]=true;
        mark(i+1,j,arr,i,j,heights);
        mark(i-1,j,arr,i,j,heights);
        mark(i,j+1,arr,i,j,heights);
        mark(i,j-1,arr,i,j,heights);
    }
    public static void main(String[] args) {

        int[][] heights = {{1,2,2,3,5},
                           {3,2,3,4,4},
                           {2,4,5,3,1},
                           {6,7,1,4,5},
                           {5,1,1,2,4}};
        pacificAtlantic(heights).forEach(i-> System.out.println(i));
    }
}
