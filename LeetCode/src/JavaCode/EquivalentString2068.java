package JavaCode;

import java.util.HashMap;
import java.util.Map;

/*Example 1:

Input: word1 = "aaaa", word2 = "bccb"
Output: false
Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
The difference is 4, which is more than the allowed 3.
*/
public class EquivalentString2068 {
	
public boolean checkAlmostEquivalent(String word1, String word2) {
        
	     Map<Character,Integer> hm1=new HashMap<>();
	     Map<Character,Integer> hm2=new HashMap<>();
	     for(char c:word1.toCharArray())
	    	 hm1.put(c, hm1.containsKey(c)?hm1.get(c)+1:1);
	     for(char c:word2.toCharArray())
	    	 hm2.put(c, hm2.containsKey(c)?hm2.get(c)+1:1);
	     boolean a=true;
	     boolean b=true;
	     boolean c=true;
	     boolean d=true;
	     for(Map.Entry<Character,Integer> e:hm1.entrySet())
	     {
	    	 if(a==false || b==false)
	    		 return false;
	    	 if(hm2.containsKey(e.getKey()))
	    		  a= Math.abs(e.getValue()-hm2.get(e.getKey()))<=3;
	    	 else 
	    		 b= Math.abs(e.getValue()-0)<=3;
	     }
	     for(Map.Entry<Character,Integer> e:hm2.entrySet())
	     {
	    	 if(c==false || d==false)
	    		 return false;
	    	 if(hm1.containsKey(e.getKey()))
	    		  c= Math.abs(e.getValue()-hm1.get(e.getKey()))<=3;
	    	 else 
	    		 d= Math.abs(e.getValue()-0)<=3;
	     }
	     return a && b && c && d;
    }

public boolean checkAlmostEquivalent_leetCode(String word1, String word2) {
    int[] frq1 = new int[26];
    int[] frq2 = new int[26];
    for (int i = 0; i < word1.length(); i++) {
        frq1[word1.charAt(i) - 97]++;
        frq2[word2.charAt(i) - 97]++;
    }
    for (int i = 0; i < 26; i++) {
        if (frq1[i] > frq2[i]){
            if (frq1[i] - frq2[i] > 3) return false;
        }else
            if (frq2[i] - frq1[i] > 3) return false;
    }
    return true;
}

public boolean checkAlmostEquivalent_leetCode2(String word1, String word2) {
    
    HashMap<Character, Integer> freqMap1 = new HashMap<>();
    HashMap<Character, Integer> freqMap2 = new HashMap<>();

    // Initialize frequency counts to 0 for 'a' to 'z'
    for (char c = 'a'; c <= 'z'; c++) {
        freqMap1.put(c, 0);
        freqMap2.put(c, 0);
    }

    // Count the frequencies of characters in word1
    for (char c : word1.toCharArray()) {
        freqMap1.put(c, freqMap1.get(c) + 1);
    }

    // Count the frequencies of characters in word2
    for (char c : word2.toCharArray()) {
        freqMap2.put(c, freqMap2.get(c) + 1);
    }

    // Compare the frequencies for each character
    for (char c = 'a'; c <= 'z'; c++) {
        int diff = Math.abs(freqMap1.get(c) - freqMap2.get(c));
        if (diff > 3) {
            return false;
        }
    }

    return true;
}

public boolean checkAlmostEquivalent_leetCode3(String word1, String word2) {
    Map<Character,Integer> map = new HashMap();
    for (int i = 0; i < word1.length(); i++) {
        map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
        map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0) - 1);
    }
    for (int i : map.values()) { //get value set
        if (i > 3 || i < -3) { 
            return false;
        }
    }
    return true;
}

	public static void main(String[] args) {

		//System.out.println(new EquivalentString2068().checkAlmostEquivalent("aaaa", "bccb"));
		
		//System.out.println(new EquivalentString2068().checkAlmostEquivalent("abcdeef", "abaaacc"));
		
		//System.out.println(new EquivalentString2068().checkAlmostEquivalent("zzzyyy", "iiiiii"));
		
		System.out.println(new EquivalentString2068().checkAlmostEquivalent("ggxogmhuk", "vpqppbupf"));
	}

}
