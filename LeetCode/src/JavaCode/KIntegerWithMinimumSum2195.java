package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*You are given an integer array nums and an integer k. Append k unique positive integers that do not appear 
 * in nums to nums such that the resulting total sum is minimum.return the sum of the k integers appended to nums.
 * Input: nums = [1,4,25,10,25], k = 2
Output: 5
Explanation: The two unique positive integers that do not appear in nums which we append are 2 and 3.
The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the minimum.
The sum of the two integers appended is 2 + 3 = 5, so we return 5.*/
public class KIntegerWithMinimumSum2195 {
	
	public long minimalKSum_1(int[] nums, int k) {   // Time limit exceeds
		 
		List<Integer> al=new ArrayList<>();
		int i=1;
		long sum=0;
		for(int a:nums)
			al.add(a);
		while(k>0)
		{
			if(!al.contains(i))
			{
				sum+=i;
				k--;
			}
			i++;
		}
      return sum;
	}
	public long minimalKSum(int[] nums, int k) {  
		 
		long ans = 0;
	    Arrays.sort(nums);

	    if (nums[0] > 1) {
	      final int l = 1;
	      final int r = Math.min(k, nums[0] - 1);
	      ans += (long) (l + r) * (r - l + 1) / 2;
	      k -= r - l + 1;
	      if (k == 0)
	        return ans;
	    }

	    for (int i = 0; i + 1 < nums.length; ++i) {
	      if (nums[i] == nums[i + 1])
	        continue;
	      final int l = nums[i] + 1;
	      final int r = Math.min(nums[i] + k, nums[i + 1] - 1);
	      ans += (long) (l + r) * (r - l + 1) / 2;
	      k -= r - l + 1;
	      if (k == 0)
	        return ans;
	    }

	    if (k > 0) {
	      final int l = nums[nums.length - 1] + 1;
	      final int r = nums[nums.length - 1] + k;
	      ans += (long) (l + r) * (r - l + 1) / 2;
	    }

	    return ans;
	}
	public long minimalKSum_leetcode(int[] nums, int k) {  
		 
		Arrays.sort(nums);
	    Set<Integer> set = new HashSet<>();
	    long sum = 0;
	    
	    for (int num: nums) {
	        if (!set.contains(num) && num <= k) {
	            k++;
	            sum += num;        
	        }            
	        set.add(num);
	    }
	    
	    long res = (long)(1 + k) * k / 2 - sum;
	    return res;     
	}
	public long minimalKSum_leetcode_oneLiner(int[] nums, int k) {  
		
	long  res = (long )k * (k + 1) / 2;
    for (int n : new TreeSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()))) 
    	if (n <= k) 
    		res += (++k) - n;  
      return res; 
	}

	public static void main(String[] args) {
		
		int[] nums= {1,4,25,10,25};int k=2;  //o/p:5
		//int[] nums= {5,6};int k=6;          //o/p:25
		
		//System.out.println(new KIntegerWithMinimumSum2195().minimalKSum(nums, k));
		
		//System.out.println(new KIntegerWithMinimumSum2195().minimalKSum_leetcode(nums, k));
		
		System.out.println(new KIntegerWithMinimumSum2195().minimalKSum_leetcode_oneLiner(nums, k));

	}

}
