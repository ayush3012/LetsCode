package JavaCode;

/*Given a string s consisting of only the characters 'a' and 'b', return true if every 'a'
 *  appears before every 'b' in the string. Otherwise, return false.
 *  Input: s = "aaabbb"
Output: true
Explanation:
The 'a's are at indices 0, 1, and 2, while the 'b's are at indices 3, 4, and 5.
Hence, every 'a' appears before every 'b' and we return true.*/
public class AllAnB2124 {
	
	public boolean checkString(String s) {

		return s.split("b").length<=1;
		
	}
	
	public boolean checkString_leetcode(String s) {

		return !s.contains("ba");
		
	}

	public static void main(String[] args) {
		String s = "aaabbb";
		//String s = "abab";
		//String s = "bbb";

		System.out.println(new AllAnB2124().checkString(s));
		
		System.out.println(new AllAnB2124().checkString_leetcode(s));
	}

}
