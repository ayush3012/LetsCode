package JavaCode;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.*/
public class GoodPair1512 {
	
	public int numIdenticalPairs(int[] nums) {

		Map<Integer,Integer> hm=new HashMap<>();
		int res=0;
		for(int a:nums)
			hm.put(a, hm.containsKey(a)?hm.get(a)+1:1);
		for(Map.Entry<Integer,Integer> e:hm.entrySet())
			res+=e.getValue()*(e.getValue()-1)/2;
      return res;
	}

	public static void main(String[] args) {
		
		//int[] nums= {1,2,3,1,1,3};
		
		//int[] nums= {1,1,1,1};
		
		int[] nums= {1,2,3};		
		
		
		System.out.println(new GoodPair1512().numIdenticalPairs(nums));

	}

}
