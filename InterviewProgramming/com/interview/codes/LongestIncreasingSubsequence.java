package com.interview.codes;

public class LongestIncreasingSubsequence {

	public static int Subsequence(int[] arr)
	{
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			int k=arr[i];
			int count=1;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]>k)
				{
					k=arr[j];
					count++;
				}
			}
			max=Math.max(max,count);
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		int[] arr= {5,3,4,7,-2,8};

		System.out.println(Subsequence(arr));
	}

}
