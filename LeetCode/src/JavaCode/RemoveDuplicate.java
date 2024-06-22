package JavaCode;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static int removeDuplicates(int[] nums) {

		Set<Integer> hs=new LinkedHashSet<>();
	      for(int i:nums)
	          hs.add(i);
	        int i=0;
	       for(int h:hs)
	         nums[i++]=h;
	        return i; 
	}

	public static void main(String[] args) 
	{
		int[] nums= {1,1,2};
		System.out.println(removeDuplicates(nums));
	}
}


