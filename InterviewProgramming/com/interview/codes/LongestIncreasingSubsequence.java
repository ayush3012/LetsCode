package com.interview.codes;

import java.util.HashSet;
import java.util.Set;

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
	static void subsequence_efficient(int[] arr)
	{
		Set<Integer> hs=new HashSet<>();
		int max=0;
		for(int i:arr) hs.add(i);
		for(int i:arr)
		{
			if(!hs.contains(i-1)) {
				int curr = i;
				int len = 1;
				while (hs.contains(curr + 1)) {
					curr++;
					len++;
				}
				max = Math.max(len, max);
			}
		}
		System.out.println("max len:"+max);
	}
	public static void main(String[] args) {
		
		int[] arr= {5,3,4,7,-2,8};

		System.out.println(Subsequence(arr));

		System.out.println();

		subsequence_efficient(arr);
	}

}
