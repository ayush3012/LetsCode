package JavaCode;

import java.util.Arrays;

/*Input: nums = [2,11,10,1,3], k = 10
Output: 3
Explanation: After one operation, nums becomes equal to [2, 11, 10, 3].
After two operations, nums becomes equal to [11, 10, 3].
After three operations, nums becomes equal to [11, 10].
At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
It can be shown that 3 is the minimum number of operations needed so that all elements of the array are greater than or equal to 10.*/
public class MinOperation3065 {
	
	 public int minOperations(int[] nums, int k) {
		 
		 Arrays.sort(nums);
		 int i=0;
		 for(i=0;i<nums.length;i++)
			 if(nums[i]==k || nums[i]>k)
				 break;
		 return i;	        
	    }

	public static void main(String[] args) {
		
		//int[] nums = {2,11,10,1,3};int k = 10;
		
		int[] nums = {1,1,2,4,9};int k = 1;
		
		System.out.println(new MinOperation3065().minOperations(nums, k));

	}

}
