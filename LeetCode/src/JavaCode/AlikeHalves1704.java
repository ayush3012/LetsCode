package JavaCode;

/*You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half
 *  and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice 
that s contains uppercase and lowercase letters.
Return true if a and b are alike. Otherwise, return false.
Example 1:
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.*/
public class AlikeHalves1704 {

public boolean halvesAreAlike(String s) {
        
	    return countVowels(s.substring(0,s.length()/2))==countVowels(s.substring(s.length()/2));
    }
   
  public int countVowels(String s)
  {
	  int count=0;
	  for(int i=0;i<s.length();i++)
		  if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'
		  || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U')
			  count++;
	  return count;
  }
	public static void main(String[] args) {
		
		//String s="book";
		//String s="textbook";
		String s="ae";
		
		System.out.println(new AlikeHalves1704().halvesAreAlike(s));

	}

}
