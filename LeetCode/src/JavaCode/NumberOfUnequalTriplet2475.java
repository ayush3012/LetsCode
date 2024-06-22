package JavaCode;

import java.util.HashSet;
import java.util.Set;

/*Input: nums = [4,4,2,4,3]
Output: 3
Explanation: The following triplets meet the conditions:
- (0, 2, 4) because 4 != 2 != 3
- (1, 2, 4) because 4 != 2 != 3
- (2, 3, 4) because 2 != 4 != 3
Since there are 3 triplets, we return 3.
Note that (2, 0, 4) is not a valid triplet because 2 > 0.*/
public class NumberOfUnequalTriplet2475 {
	
	public int unequalTriplets(int[] nums) {

		int res = 0;
		Set<Integer> set = new HashSet<>();     //not working for int[] nums= {1,3,1,2,4};
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			while (j<nums.length && set.size() < 3) {
				set.add(nums[j++]);
			}
			if (set.size() == 3) {
				res++;
				set.clear();
			}
		}
		return res;
	}
	
	 public int unequalTriplets_leetcode(int[] nums) {
	        
			int res = 0;
			int n=nums.length;
			
	        for(int i=0;i<n-2;i++)
	        {
	            for(int j=i+1;j<n-1;j++)
	            {
	                for(int k=j+1;k<n;k++)
	                  if(nums[i]!=nums[j] && nums[j]!=nums[k] && nums[k]!=nums[i])
	                    res++;
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		
		//int[] nums= {4,4,2,4,3};
		//int[] nums= {1,1,1,1,1};
		int[] nums= {1,3,1,2,4};
		System.out.println(new NumberOfUnequalTriplet2475().unequalTriplets(nums));

	}

}
