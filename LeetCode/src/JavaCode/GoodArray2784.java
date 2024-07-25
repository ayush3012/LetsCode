package JavaCode;

import java.util.Arrays;
/**
 * https://leetcode.com/problems/check-if-array-is-good/description/
 * 
 * You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].

base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once, plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].

Return true if the given array is good, otherwise return false.

Note: A permutation of integers represents an arrangement of these numbers.
 * */
public class GoodArray2784 {
	
	public boolean isGood(int[] nums) {

		if(nums.length==1)
			return false;
		boolean flag=true;
		Arrays.sort(nums);
		int i=0;
		for(i=0;i<=nums.length-2;i++)
			if(nums[i]!=i+1)
				flag=false;
		if(nums[i]!=nums.length-1)
			flag=false;
		return flag;
	}

	public static void main(String[] args) {
		
       int[] nums = {2, 1, 3};   //1 2 3
		
		//int[] nums = {1, 3, 3, 2};
		
		//int[] nums = {1};
		
		//int[] nums = {1,1};
		
		//int[] nums = {1,1,2};
		
		System.out.print(new GoodArray2784().isGood(nums));

	}

}
