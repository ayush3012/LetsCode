package com.mypack.TwoDArray;

public class RottenOranges {

	public static int rottingOranges(int[][] grid)
	{
		boolean changed=false;
		int no=2;
		while(true)
		{
			for(int i=0;i<grid.length;i++) {
				for(int j=0;j<grid[0].length;j++)
				{
					if(grid[i][j]==no)
					{
						if(isSafe(grid, i+1, j) && grid[i+1][j]==1)
						{
							grid[i+1][j]=grid[i][j]+1;
							changed=true;
						}
						if(isSafe(grid, i-1, j) && grid[i-1][j]==1)
						{
							grid[i-1][j]=grid[i][j]+1;
							changed=true;
						}
						if(isSafe(grid, i, j+1) && grid[i][j+1]==1)
						{
							grid[i][j+1]=grid[i][j]+1;
							changed=true;
						}
						if(isSafe(grid, i, j-1) && grid[i][j-1]==1)
						{
							grid[i][j-1]=grid[i][j]+1;
							changed=true;
						}
					}
				}
			}
			if(!changed)
				break;
			changed=false;
			no++;
		}
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
				if(grid[i][j]==1)
					return -1;
		return no-2;
	}
	static boolean isSafe(int[][] grid,int i,int j)
	{
		return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
	}
	public static void main(String[] args) {

		int[][] grid= {{2,1,1},
				       {1,1,0},
				       {0,1,1}};
		
		System.out.println(rottingOranges(grid));
	}

}
