package JavaCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.*/
public class SortCharacterByFrequency451 {
	
	 public String frequencySort(String s) {
	        
		    Map<Character,Integer> hm=new HashMap<>();
		    Map<Character,Integer> lhm=new LinkedHashMap<>();
		    String res="";
		    for(char c:s.toCharArray())
		    	hm.put(c,hm.containsKey(c)?hm.get(c)+1:1);
		    
		    hm.entrySet().stream().sorted((e1,e2)->e2.getValue()-e1.getValue()).forEach(e->lhm.put(e.getKey(),e.getValue()));
		    for(Map.Entry<Character, Integer> e:lhm.entrySet())
		    {
		    	int a=e.getValue();
		    	while(a-->0)
		    		res+=e.getKey();
		    }
		    return res;
	    }

	public static void main(String[] args) {
		
		String s="tree";
		
		System.out.println(new SortCharacterByFrequency451().frequencySort(s));

	}

}
