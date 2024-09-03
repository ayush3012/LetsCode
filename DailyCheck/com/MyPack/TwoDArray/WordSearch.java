package com.mypack.TwoDArray;

/**
 * Here we will use DFS algorithm because at each point if we find desired character
 *  we have to traverse every direction in sequence
 *  
 *  NOTE- in rotten orange problem we have to traverse each direction to the rotten 
 *  one in unit of time so we need to apply BFS there
 *  */
public class WordSearch {
	
	public static boolean findWord(char[][] grid,String target)
	{
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
				if((grid[i][j]==target.charAt(0)) && dfs(grid,i,j,0,target))
					return true;
		return false;
	}
	
	public static boolean dfs(char[][] grid,int i,int j,int count,String target)
	{
		if(count==target.length())
			return true;
		if(i==-1 || i==grid.length || j==-1 || j==grid[0].length || grid[i][j]!=target.charAt(count))
			return false;
		char temp=grid[i][j];
		grid[i][j]='*';
		
		boolean found=  dfs(grid,i-1,j,count+1,target) ||
				        dfs(grid,i+1,j,count+1,target) ||
				        dfs(grid,i,j-1,count+1,target) ||
				        dfs(grid,i,j+1,count+1,target);
		grid[i][j]=temp;
		return found;
	}

	public static void main(String[] args) {

		char[][] grid= {{'A','N','S','Q'},
				        {'S','O','L','R'},
				        {'K','T','O','G'}};

		String target="SOLO";

		System.out.println(findWord(grid,target));

	}

}
