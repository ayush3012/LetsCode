package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".*/
public class AllAnagramInString438 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> al = new ArrayList<>();
		for (int i = 0; i < s.length() - p.length()+1; i++)
			if (isAnagram(s.substring(i, i + p.length()), p))
				al.add(i);
		return al;
	}                                                            // All test cases passed but time limit exceeded

	public boolean isAnagram(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		return new String(ch1).equals(new String(ch2));
	}

	public static void main(String[] args) {

		String s = "cbaebabacd";String p = "abc";
		//String s = "abab";String p = "ab";

		new AllAnagramInString438().findAnagrams(s, p).forEach(i -> System.out.print(i + " "));

	}

}
