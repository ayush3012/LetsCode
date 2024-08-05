package JavaCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each
 *  array.

Example 1:

Input: nums1 = [4,1,3], nums2 = [5,7]
Output: 15
Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is
 the smallest number we can have.*/

public class SmallestNumberFromTwoArray2605 {

	public int minNumber(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		boolean flag=false;
		int val=-1;
		Map<Integer,Integer> frequency=new HashMap<>();
		for(int i:nums1)
			frequency.put(i, frequency.containsKey(i)?frequency.get(i)+1:1);
		for(int i:nums2)
			frequency.put(i, frequency.containsKey(i)?frequency.get(i)+1:1);
		for(Map.Entry<Integer,Integer> e:frequency.entrySet())
			if(e.getValue()>1)
			{
				flag=true;
				val=e.getKey();
				break;
			}
		return flag?val:(nums1[0]<nums2[0]?nums1[0]*10+nums2[0]:nums2[0]*10+nums1[0]);
	}

	public int minNumber_leetcode(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		Set<Integer> set = new HashSet<>();

		for(int i : nums1) set.add(i);
		for(int n : nums2) if(set.contains(n)) return n; 


		return nums1[0] < nums2[0]?nums1[0] * 10 + nums2[0]: nums2[0] * 10 + nums1[0];
	}

	public static void main(String[] args) {
		int[] nums1 = {4,1,3}; int[] nums2 = {5,7};
		//int[] nums1 = {3,5,2,6}; int[] nums2 = {3,1,7};

		System.out.print(new SmallestNumberFromTwoArray2605().minNumber(nums1, nums2));

	}

}
