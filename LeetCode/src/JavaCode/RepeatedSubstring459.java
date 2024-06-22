package JavaCode;

/*Given a string s, check if it can be constructed by taking a substring of it and appending 
 * multiple copies of the substring together.
 * Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.*/
public class RepeatedSubstring459 {
	
	public boolean repeatedSubstringPattern(String s) {
		for(int i=1;i<s.length()/2;i++)
		{
			if(s.length()%i==0)
			{
				String pat=s.substring(0,i);
				StringBuilder sb=new StringBuilder();
				for(int j=0;j<s.length()/i;j++)
					sb.append(pat);
				if(sb.toString().equals(s))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		//String s = "abab";
		//String s = "aba";
		//String s = "abcabcabcabc";
		//String s="a";
		//String s="ababab";
		String s="abaababaab";
		
		System.out.println(new RepeatedSubstring459().repeatedSubstringPattern(s));

	}

}
