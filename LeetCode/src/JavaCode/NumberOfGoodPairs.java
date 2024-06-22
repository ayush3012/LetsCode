package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

	 public static int numIdenticalPairs(int[] nums) {
	        
	        Map<Integer,Integer> hm=new HashMap<>();
	       for(int i:nums)
	    	   hm.put(i,hm.containsKey(i)?hm.get(i)+1:1);

	       return (int)hm.values().stream().map(i->i*(i-1)/2).reduce(0,(a,b)->a+b);
	        
	      
	 }
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,1,1,3};

		
		System.out.println(numIdenticalPairs(nums));
	}

}
