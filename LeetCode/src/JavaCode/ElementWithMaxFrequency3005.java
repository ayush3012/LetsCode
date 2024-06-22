package JavaCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.
Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.*/
public class ElementWithMaxFrequency3005 {
	
	public int maxFrequencyElements(int[] nums) {

		Map<Integer,Integer> hm=new HashMap<>();
		Map<Integer,Integer> lhm=new LinkedHashMap<>();
		for(int a:nums)
			hm.put(a, hm.getOrDefault(a, 0)+1);
		hm.entrySet().stream().sorted((e1,e2)->e2.getValue()-e1.getValue()).forEach(e->lhm.put(e.getKey(),e.getValue()));
		int max=0;
		int res=0;
		int count=0;
		for(Map.Entry<Integer,Integer> e:lhm.entrySet())
		{
			if(count==0)
			{
				max=e.getValue();
				count++;
			}
			if(max==e.getValue())
				res+=e.getValue();
		}
		return res;
		
	}
	 public int maxFrequencyElements_leetcode(int[] nums) {
	        int count = 0;
	        Map<Integer, Integer> frequencyMap = new HashMap<>();
	        int maxFreq = 0;

	        for (int num : nums) {
	            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
	            maxFreq = Math.max(maxFreq, frequencyMap.get(num));
	        }

	        for (int freq : frequencyMap.values()) {
	            if (freq == maxFreq)    count += freq;
	        }

	        return count;
	    }

	public static void main(String[] args) {
		//int[] nums = {1,2,2,3,1,4};
		int[] nums = {1,2,3,4,5};
		System.out.println(new ElementWithMaxFrequency3005().maxFrequencyElements(nums));
	}

}
