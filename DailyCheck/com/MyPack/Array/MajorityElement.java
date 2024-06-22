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
	public static void main(String[] args) {
		
        int[] arr= {1,2,8,7,2,6,5};   
		
		System.out.println(major(arr));
		
	}

}
