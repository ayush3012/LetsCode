package com.mypack.Array;

public class MinimumLengthSubarrayWithGivenSum {
	
	public static int subArray(int[] arr,int k)
	{
		int window=0;
		int left=0;
		int ans=arr.length+1;
		for(int right=0;right<arr.length;right++)
		{
			 window+=arr[right];
			   while(window>k)
				   window-=arr[left++];
			   if(window==k)
				   ans=Math.min(right-left+1,ans);
		}
		return ans==arr.length+1?0:ans;
	}

	public static void main(String[] args) {
		
		int[] arr= {2,4,6,10,2,1};
		int k=12;

		System.out.println(subArray(arr, k));
	}

}
