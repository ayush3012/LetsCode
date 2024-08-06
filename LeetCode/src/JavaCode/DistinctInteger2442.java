package JavaCode;

import java.util.HashSet;
import java.util.Set;
/**
 * You are given an array nums consisting of positive integers.

You have to take each integer in the array, reverse its digits, and add it to the end of the array.
 You should apply this operation to the original integers in nums.

Return the number of distinct integers in the final array.

*Input: nums = [1,13,10,12,31]
Output: 6
Explanation: After including the reverse of each number, the resulting array is [1,13,10,12,31,1,31,1,21,13].
The reversed integers that were added to the end of the array are underlined. Note that for the integer 10, after reversing it, it becomes 01 which is just 1.
The number of distinct integers in this array is 6 (The numbers 1, 10, 12, 13, 21, and 31).
*/

public class DistinctInteger2442 {
	public int countDistinctIntegers(int[] nums) {

		int[] res=new int[2*nums.length];
		int k=nums.length;
		Set<Integer> duplicate=new HashSet<>();
		System.arraycopy(nums, 0, res, 0, nums.length);
		for(int i=0;i<nums.length;i++)
			res[k++]=Integer.valueOf(new StringBuffer(""+nums[i]).reverse().toString());
		for(int i:res)
			duplicate.add(i);
		return duplicate.size();		
	}
	
	 public int countDistinctIntegers_leetcode(int[] nums) {
	        Set<Integer> distinctIntegers = new HashSet<>();
	        for (int num : nums) {
	            distinctIntegers.add(num);
	            int reverseNum = Integer.parseInt(new StringBuilder().append(num).reverse().toString());
	            distinctIntegers.add(reverseNum);
	        }
	        return distinctIntegers.size();
	    }
	 
	 public int countDistinctIntegers_leetcode2(int[] nums) {
	        Set<Integer> ans = new HashSet<>();
	        for(int i=0; i<nums.length; i++){
	            int n=nums[i];
	            ans.add(n);
	            if(n>9){
	                ans.add(reversenum(n));
	            }
	        }
	        return ans.size();
	    }
	    
	    public int reversenum(int n){
	        int ans = 0;
	        while(n>0){
	            ans = ans*10 + n%10;
	            n/=10;
	        }
	        return ans;
	    }

	public static void main(String[] args) {
		int[] nums = {1,13,10,12,31};
		System.out.print(new DistinctInteger2442().countDistinctIntegers(nums));

	}

}
