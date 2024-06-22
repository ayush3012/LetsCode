package JavaCode;

import java.util.Arrays;

/*
 * You are given an array of integers nums of length n.
The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.
You need to divide nums into 3 disjoint contiguous subarrays Return the minimum possible sum of the cost of these subarrays.
Input: nums = [1,2,3,12]
Output: 6
Explanation: The best possible way to form 3 subarrays is: [1], [2], and [3,12] at a total cost of 1 + 2 + 3 = 6.
The other possible ways to form 3 subarrays are:
- [1], [2,3], and [12] at a total cost of 1 + 2 + 12 = 15.
- [1,2], [3], and [12] at a total cost of 1 + 3 + 12 = 16.*/
public class MinimumCostArray3010 {
	
	public int minimumCost(int[] nums) {

		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]<min1)
				{
				  min2=min1;
				  min1=nums[i];
				}
			else if(nums[i]<min2)
				min2=nums[i];
		}
		return nums[0]+min1+min2;
	}
	 public int minimumCost_leetcode(int[] v) {
	        int n = v.length;
	        int s = v[0];
	        Arrays.sort(v, 1, n);
	        s = s + v[1] + v[2];
	        return s;
	    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,12};
		//int[] nums = {5,4,3};
		//int[] nums = {10,3,1,1};
		
		System.out.println(new MinimumCostArray3010().minimumCost(nums));
	}

}
