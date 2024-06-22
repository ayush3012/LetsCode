package JavaCode;

import java.util.HashMap;
import java.util.Map;

/*You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.*/
public class PossibleWords1160 {
	
	public int countCharacters(String[] words, String chars) {

		Map<Character,Integer> hm=new HashMap<>();
		for(char c:chars.toCharArray())
			hm.put(c, hm.containsKey(c)?hm.get(c)+1:1);
		int res=0;
		for(String s:words)
		{
			Map<Character,Integer> lhm=new HashMap<>();
			int ls=0;
			for(char c:s.toCharArray())
				lhm.put(c, lhm.containsKey(c)?lhm.get(c)+1:1);
			for(Map.Entry<Character,Integer> e:lhm.entrySet())
			{
				if(hm.containsKey(e.getKey()) && e.getValue()<=hm.get(e.getKey()))
					ls+=e.getValue();
				else
				{
					ls=0;
					break;
				}
			}
           res+=ls;
		}
		return res;
	}

	public static void main(String[] args) {
		String[] words = {"cat","bt","hat","tree"};String chars = "atach";
		//String[] words = {"hello","world","leetcode"};String chars = "welldonehoneyr";
		
		System.out.println(new PossibleWords1160().countCharacters(words, chars));
		
	}

}
