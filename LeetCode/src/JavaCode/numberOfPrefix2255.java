package JavaCode;

/*You are given a string array words and a string s, where words[i] and s comprise only of lowercase English letters.
Return the number of strings in words that are a prefix of s.
A prefix of a string is a substring that occurs at the beginning of the string. A substring is a contiguous 
sequence of characters within a string.
 * */
public class numberOfPrefix2255 {
	
	 public int countPrefixes(String[] words, String s) {
		 
		 int count=0;
		 for(String word:words)
			 if(s.startsWith(word))
				 count++;
		 return count;
	        
	    }

	public static void main(String[] args) {
		
		//String[] words = {"a","b","c","ab","bc","abc"}; String s = "abc";
		
		String[] words = {"a","a"}; String s = "aa";
		
		System.out.println(new numberOfPrefix2255().countPrefixes(words, s));

	}

}
