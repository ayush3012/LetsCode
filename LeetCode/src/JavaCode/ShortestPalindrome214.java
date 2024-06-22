package JavaCode;

/*
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.
Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
 */
public class ShortestPalindrome214 {
	
	public String shortestPalindrome(String s) {
		String rev=new StringBuffer(s).reverse().toString();
		for(int i=0;i<s.length();i++)
		{
			if(s.startsWith(rev.substring(i)))
				return rev.substring(0,i)+s;
		}
		return rev+s;
    }
	public static void main(String[] args) {

      //System.out.println(new ShortestPalindrome214().shortestPalindrome("aacecaaa"));
      
      //System.out.println(new ShortestPalindrome214().shortestPalindrome("abcd")); aabca
      
      System.out.println(new ShortestPalindrome214().shortestPalindrome("aabca"));  //acbaa

	}

}
