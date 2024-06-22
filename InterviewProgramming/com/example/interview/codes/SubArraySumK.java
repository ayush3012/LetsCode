package com.interview.codes;

public class SubArraySumK {
	
	public static void SubArray(int[] arr,int k)
	{
		int sum=arr[0];
		int start=0;
		for(int i=1;i<arr.length;i++)
		{
			while(sum>k && start<i-1)
			{
				sum-=arr[start];
				start++;
			}
			if(sum==k)
				System.out.println(start+" "+i);
			if(i<arr.length)
				sum+=arr[i];
		}
	}
	public static void main(String[] args) 
	{
		int arr[] = {2,3,5,9,-1,6,2};
		int k=8;
		SubArray(arr,k);
	}

}
