package com.mypack.Array;

import java.util.Arrays;

public class MajorityElement {

	public static int major(int[] arr)
	{
		Arrays.sort(arr);
		int count=1;
		int res=0;
		int ind=0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==arr[i+1])
				  count++;
			if(res<count)
			{
				res=count;
				ind=i;
			}
		}
		return arr[ind];
	}

	// element appear more than n/2
	static void MajorityElementInMinimumJump(int[] arr)
	{
		int count=0;
		int candidate=0;
		for(int i:arr)
		{
			if(count==0)
				candidate=i;
			count+=candidate==i?1:-1;
		}
		System.out.println("count of element appear:"+candidate);
	}
	public static void main(String[] args) {
		
        int[] arr= {1,2,8,7,2,6,5};   
		
		System.out.println(major(arr));

		System.out.println();

		int[] arr1= {9,9,8,7,2,9,9};

		MajorityElementInMinimumJump(arr1);
		
	}

}
