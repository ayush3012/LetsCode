package com.mypack.Array;

import java.util.ArrayList;
import java.util.List;

public class AllSubArrayOfArray {

	public static List<int[]> generateAllSubArray(int[] nums)
	{
		List<int[]> result=new ArrayList<>();
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i;j<nums.length;j++)
			{
				int[] subArray=new int[j-i+1];
				System.arraycopy(nums, i, subArray,0,j-i+1);
				result.add(subArray);
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {

		int[] nums = {1,2,1};
		
		for(int[] arr:generateAllSubArray(nums))
		{
			for(int i:arr)
			  System.out.print(i+" ");
			System.out.println();
		}
		
	}



}
