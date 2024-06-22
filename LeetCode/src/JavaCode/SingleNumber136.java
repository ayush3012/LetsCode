package JavaCode;

import java.util.HashMap;
import java.util.Map;

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
*/
public class SingleNumber136 {

	public static int singleNumber_MySolution(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
		for(int a:nums)
			hm.put(a,!hm.containsKey(a)?1:hm.get(a)+1);
		for(Map.Entry<Integer,Integer> e:hm.entrySet())
			if(e.getValue()==1)
				return e.getKey();
		return -1;
    }
	public static int LeetCodeBestSolution(int[] nums)
	{
		int ans = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            ans = ans ^ nums[i];
        }

        return ans;
	}
	public static void main(String[] args) {
		
		int[] arr= {2,2,1};
		System.out.println(singleNumber_MySolution(arr));

	}

}
