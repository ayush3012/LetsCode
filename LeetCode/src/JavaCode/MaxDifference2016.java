package JavaCode;

/**Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] 
 * (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1.
Input: nums = [7,1,5,4]
Output: 4
Explanation:
The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.*/
public class MaxDifference2016 {
public int maximumDifference(int[] nums) {
		
		int max=-1;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++)
		{
			 min=Math.min(min, nums[i]);
			 max=Math.max(nums[i]-min, max);
		}
		return max==0?-1:max;
	}

	public static void main(String[] args) {
		//int[] nums = {7,1,5,4};
		
				//int[] nums = {9,4,3,2};
				
				int[] nums = {1,5,2,10};
				System.out.println(new MaxDifference2016().maximumDifference(nums));

	}

}
