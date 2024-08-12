package JavaCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**You are given a 0-indexed array nums of length n containing distinct positive integers.
 *  Return the minimum number of right shifts required to sort nums and -1 if this is not possible.

A right shift is defined as shifting the element at index i to index (i + 1) % n, for all indices.*/

public class MinimumRightShift2855 {

	public int minimumRightShifts(List<Integer> nums) {
		if(isSorted(nums))
			return 0;
		int k=0;
		while(!isSorted(nums))
		{
			Collections.rotate(nums, 1);
			k++;
			if(k==nums.size())
			{
				k=-1;
				break;
			}
		}
		return k;
	}
	public boolean isSorted(List<Integer> nums)
	{
		return nums.stream().sorted().collect(Collectors.toList()).equals(nums);
	}
	public static void main(String[] args) {
		//int[] nums = {3,4,5,1,2};

		int[] nums = {1,3,5};

		//int[] nums = {2,1,4};

		List<Integer> al=new ArrayList<>();
		for(int i:nums)
			al.add(i);

		System.out.println(new MinimumRightShift2855().minimumRightShifts(al));

	}

}
