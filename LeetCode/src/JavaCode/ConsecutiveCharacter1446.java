package JavaCode;

/**
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.
Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.*/
public class ConsecutiveCharacter1446 {

	public int maxPower(String s) {

		int max=0;
		String local="";
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)==s.charAt(i+1))
				local+=s.charAt(i);
			else
				local="";
			if(max<local.length())
				max=local.length();
		}
		return max+1;
	}

	public static void main(String[] args) {
		//String s = "leetcode";
		String s= "abbcccddddeeeeedcba";

		System.out.println(new ConsecutiveCharacter1446().maxPower(s));

	}

}
