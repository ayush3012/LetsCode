package JavaCode;

import java.util.HashMap;
import java.util.Map;

/*You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:

nums1.length == nums2.length == nums.length / 2.
nums1 should contain distinct elements.
nums2 should also contain distinct elements.
Return true if it is possible to split the array, and false otherwise.
Input: nums = [1,1,2,2,3,4]
Output: true
Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].*/
public class SplitArray3046 {
	
	public boolean isPossibleToSplit(int[] nums) {

		Map<Integer,Integer> hm=new HashMap<>();
		for(int a:nums)
			hm.put(a,!hm.containsKey(a)?1:hm.get(a)+1);
		for(Map.Entry<Integer,Integer> e:hm.entrySet())
			if(e.getValue()>2)
				return false;
		return true;
	}

	public static void main(String[] args) {
		
		//int[] nums = {1,1,2,2,3,4};
		int[] nums = {1,1,1,1};
		
		System.out.println(new SplitArray3046().isPossibleToSplit(nums));
	}

}
