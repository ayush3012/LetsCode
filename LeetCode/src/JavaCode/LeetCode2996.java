package JavaCode;

import java.util.ArrayList;
import java.util.List;

/*   smallest-missing-integer-greater-than-sequential-prefix-sum
 * 
 * You are given a 0-indexed array of integers nums.

A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix consisting only of nums[0] is sequential.

Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.
Example 1:

Input: nums = [1,2,3,2,5]
Output: 6
Explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 6 is not in the array, therefore 6 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.
Example 2:

Input: nums = [3,4,5,1,12,14,13]
Output: 15
Explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12. 12, 13, and 14 belong to the array while 15 does not. Therefore 15 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.*/
public class LeetCode2996 {
	
	 public int missingInteger(int[] nums) {
		 
		List<Integer> al = new ArrayList<>();
		for (int a : nums)
			al.add(a);
		int sum = 0;
		int i = 0;
		for (i = 0; i < nums.length-1; i++) {
			if (nums[i] == nums[i + 1] - 1)
				sum += nums[i];
			else
				break;
		}
		sum += nums[i];
		while (al.contains(sum))
			sum += 1;
		return sum;
	}

	public static void main(String[] args) {
		
		//int[] nums = {1,2,3,2,5};
		//int[] nums = {3,4,5,1,12,14,13};
		int[] nums = {29,30,31,32,33,34,35,36,37};
		
		System.out.println(new LeetCode2996().missingInteger(nums));

	}

}
