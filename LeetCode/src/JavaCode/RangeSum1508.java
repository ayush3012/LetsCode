package JavaCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous 
 * subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array.
 Since the answer can be a huge number return it modulo 109 + 7.*/

public class RangeSum1508 {
	public int rangeSum(int[] nums, int n, int left, int right) {
		List<List<Integer>> res=new ArrayList<>();
		int MOD = 1000000007;
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i;j<nums.length;j++)
			{
				int[] sub=new int[j-i+1];
				System.arraycopy(nums, i, sub, 0, j-i+1);
				List<Integer> temp=new ArrayList<>();
				int sum=0;
				for(int k:sub)
				{
					sum+=k;
				}
				sum%=MOD;
				temp.add(sum);
				res.add(temp);
			}
		}
		return res.stream().flatMap(i->i.stream()).sorted().skip(left-1).limit(right-left+1).reduce((a,b)->(a+b)%MOD).get();
	}

	public int rangeSum_leetcode(int[] nums, int n, int left, int right) {
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int prefix = 0;
			for (int j = i; j < n; j++) {
				prefix += nums[j];
				arr.add(prefix);
			}
		}
		Collections.sort(arr);
		int result = 0;
		int MOD = 1000000007;
		for (int i = left - 1; i < right; i++) {
			result = (result + arr.get(i)) % MOD;
		}
		return result;
	}

	public static void main(String[] args) {
		//int[] nums = {1,2,3,4};int n = 4;int left = 1;int right = 5;

		//int[] nums = {1,2,3,4};int n = 4;int left = 3;int right = 4;

		int[] nums = {1,2,3,4};int n = 4;int left = 1;int right = 10;

		System.out.println(new RangeSum1508().rangeSum(nums, n, left, right));

	}

}
