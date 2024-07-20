package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubArrayDistinctElementSquareSumOne2913 {
	
	public List<int[]> generatingAllSubArray(int[] nums)
	{
		List<int[]> result=new ArrayList<>();
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i;j<nums.length;j++)
			{
				int[] subArray=new int[j-i+1];
				System.arraycopy(nums, i, subArray, 0, j-i+1);
				result.add(subArray);
			}
		}
		return result;
	}
	public int sumCounts(List<Integer> nums) {
		List<int[]> result=new ArrayList<>();
		int[] arr=new int[nums.size()];
		int k=0;
		for(int i:nums)
			arr[k++]=i;
		result=generatingAllSubArray(arr);
		int res=0;
		for(int[] sub:result)
		{
			Set<Integer> uniqueElement=new HashSet<>();
			for(int i:sub)
				uniqueElement.add(i);
			res+=uniqueElement.size()*uniqueElement.size();
		}
       return res;
	}

	public static void main(String[] args) {
		
		//int[] nums = {1,2,1};
		int[] nums = {1,1};
		List<Integer> list=new ArrayList<>();
		for(int i:nums)
			list.add(i);
		
		System.out.print("sum : "+ new SubArrayDistinctElementSquareSumOne2913().sumCounts(list));

	}

}
