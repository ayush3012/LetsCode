package com.mypack.Array;

import java.util.Arrays;

public class MinimumNumberOfPlatform {
	
	public static void MinimumPlatform(int[] arr,int[] dep,int n)
	{
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i=0;
		int j=0;
		int count=0;
		int ans=0;
		while(i<n)
		{
			if(arr[i]<=dep[j])
			{
				count++;
				ans=Math.max(ans, count);
				i++;
			}
			else
			{
				count--;
				j++;
			}
		}
		System.out.println("Minimum number of platform required : "+ans);
	}

	public static void main(String[] args) {
		
		// int arr[] = { 100, 300, 500 };
	    // int dep[] = { 900, 400, 600 };
		
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
	     
	     MinimumPlatform(arr, dep, arr.length);

	}

}
