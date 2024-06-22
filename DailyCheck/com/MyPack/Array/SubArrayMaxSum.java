package com.mypack.Array;

public class SubArrayMaxSum {
	
	public static void SubArrayMaxSum(int[] arr)
	{
		int max_so_far=0;
		int max=Integer.MIN_VALUE;
		int s=0;
		int e=-1;
		int start=0;
		for(int i=0;i<arr.length;i++)
		{
			max_so_far=max_so_far+arr[i];
			if(max<max_so_far)
				{
				  max=max_so_far;
				  start=s;
				  e=i;
				 }
			if(max_so_far<0)
			{
				max_so_far=0;
				s=s+1;
			}
		}
		System.out.println("subarray with maximum contigious sum "+max+" found b/w "+start+" to "+e);
	}

	public static void main(String[] args) {
		
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		
		//int[] arr = { 1,2,3,-4,-5,6,7 };
		
		SubArrayMaxSum(arr);
	}

}
