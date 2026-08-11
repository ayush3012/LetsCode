package DailyCheck_WarmUP.TwoDArray;

public class MaxAreaOfIsland695 {

    static int dfs(int[][] grid,int i,int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0)
            return 0;
        grid[i][j]=0;
        return 1+ dfs(grid,i+1,j) +
                  dfs(grid,i-1,j) +
                  dfs(grid,i,j+1) +
                  dfs(grid,i,j-1) ;
    }
    static void maxAreaOfIsland(int[][] grid)
    {
        int max=0;
        for(int i=0;i< grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    max=Math.max(max,dfs(grid,i,j));
            }
        }
        System.out.println("Max Area:"+max);
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        maxAreaOfIsland(grid);
    }
}
