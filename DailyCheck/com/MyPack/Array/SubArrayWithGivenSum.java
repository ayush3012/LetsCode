package com.mypack.Array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
	
	public static void SubArraySum(int[] arr,int k)
	{
		Map<Integer,Integer> map=new HashMap<>();
		int start=0;
		int end=-1;
		int sum=0;
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			if(sum==k)
			{
				start=0;
				end=i;
				count++;
				System.out.println("sum found b/w "+start+" to "+end);
			}
			if(map.containsKey(sum-k))
			{
				start=map.get(sum-k)+1;
				end=i;
				count++;
				System.out.println("sum found b/w "+start+" to "+end);
			}
			map.put(sum,i);
		}
		System.out.println("total subarray: "+count);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
        int sum = -10;
        
        SubArraySum(arr, sum);
	}

}
