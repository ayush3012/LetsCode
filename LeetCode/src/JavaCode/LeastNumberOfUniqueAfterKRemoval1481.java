package JavaCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.*/
public class LeastNumberOfUniqueAfterKRemoval1481 {
	
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        Map<Integer,Integer> lhm=new LinkedHashMap<>();
        for(int a:arr)
          hm.put(a, hm.containsKey(a)?hm.get(a)+1:1);
        hm.entrySet().stream().sorted((e1,e2)->e1.getValue()-e2.getValue()).forEach(e->lhm.put(e.getKey(),e.getValue()));
        
        for(Map.Entry<Integer,Integer> e:lhm.entrySet())
        {
        	if(e.getValue()<k)
        		{
        		   k-=e.getValue();
        		   lhm.put(e.getKey(), 0);
        		}
        	else
        	{
        		lhm.put(e.getKey(), e.getValue()-k);
        		break;
        	}
        }
        int count=0;
        for(Map.Entry<Integer, Integer> e:lhm.entrySet())
        	if(e.getValue()!=0)
        		count++;
        return count;
        		
    }

	public static void main(String[] args) {
		
		int[] arr = {5,5,4};int k = 1;
		//int[] arr = {4,3,1,1,3,3,2};int k = 3;
		
		System.out.println(new LeastNumberOfUniqueAfterKRemoval1481().findLeastNumOfUniqueInts(arr, k));
		

	}

}
