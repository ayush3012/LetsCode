package JavaCode;

import java.util.ArrayList;
import java.util.List;

/*Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also 
 * exists in the array.Return the positive integer k. If there is no such integer, return -1.
 * Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.*/
public class PositiveNegativeExist2441 {
	
	public int findMaxK(int[] nums) {

		int max=0;
		List<Integer> al=new ArrayList<>();
		for(int a:nums)
			al.add(a);
		for(int a:al)
		{
			if(max<a && al.contains(-a))
				max=a;
		}
		return max==0?-1:max;
	}

	public static void main(String[] args) {
		
		int[] nums = {-1,2,-3,3};
		//int[] nums = {-1,10,6,7,-7,1};
		//int[] nums = {-10,8,6,7,-2,-3};
		
		System.out.println(new PositiveNegativeExist2441().findMaxK(nums));
	}

}
