package JavaCode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


/**Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
*/
public class WordPattern290 {

	public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
		Set<Character> set1=new HashSet<>();
		for(char c:pattern.toCharArray())
			set1.add(c);
		Set<String> set2=new HashSet<>();
		for(String c:words)
			set2.add(c);
		Map<Character,Set<String>> lhm=new LinkedHashMap<>();
		if(words.length!=pattern.length())
			return false;
		
		if(set1.size()!=set2.size())
			return false;
		
		int i=0;
		for(String w:words)
		{
			Set<String> al;
			if(lhm.containsKey(pattern.charAt(i)))
				al=lhm.get(pattern.charAt(i));
			else
				al=new HashSet<>();
			al.add(w);
			lhm.put(pattern.charAt(i), al);
			i++;
		}
		for(Map.Entry<Character, Set<String>> e:lhm.entrySet())
			if(e.getValue().size()>1)
				return false;
		return true ;
    }
	public static void main(String[] args) {
		
		//String pattern = "abba";String s = "dog cat cat dog";
		//String pattern = "abba";String s = "dog cat cat fish";
		String pattern = "aaaa";String s = "dog cat cat dog";
		System.out.println(new WordPattern290().wordPattern(pattern, s));

	}

}
