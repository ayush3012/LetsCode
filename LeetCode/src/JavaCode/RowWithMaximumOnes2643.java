package JavaCode;

/*Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the
 *  number of ones in that row.In case there are multiple rows that have the maximum count of ones, the row with the 
 *  smallest row number should be selected.Return an array containing the index of the row, and the number of ones in it.
 *  Input: mat = [[0,1],[1,0]]
Output: [0,1]
Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and
 the maximum count of ones (1). So, the answer is [0,1]*/
public class RowWithMaximumOnes2643 {
	
	public int[] rowAndMaximumOnes(int[][] mat) {
		int row=0;
		int ones=0;
		int lo=0;
		int ind=0;
		int[] arr=new int[2];
		for(int i=0;i<mat[ind].length;i++)
		{
			if(mat[ind][i]==1)
			{
				lo++;
			}
			if(lo>ones)
			{
				ones=lo;
				row=ind;
			}
			if(i==mat[ind].length-1)
			{
				ind++;
				i=-1;
				lo=0;
			}
			if(ind==mat.length)
				break;
		}
      arr[0]=row;
      arr[1]=ones;
      return arr;
	}

	public static void main(String[] args) {
		//int[][] mat = {{0,1},{1,0}};
		//int[][] mat = {{0,0,0},{0,1,1}};
		int[][] mat = {{0,0},{1,1},{0,0}};
		
		int[] arr=new int[2];
		
		arr=new RowWithMaximumOnes2643().rowAndMaximumOnes(mat);
		
		for(int a:arr)
			System.out.print(a+" ");

	}

}
