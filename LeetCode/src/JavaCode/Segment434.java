package JavaCode;

import java.util.StringTokenizer;

/*Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.
Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]*/
public class Segment434 {
	
	public int countSegments(String s) {

		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
				count++;
		}
		return count;
	}
	public int countSegments_leetcode(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int word=0;
        while(st.hasMoreTokens()){
            word++;
            st.nextToken();
        }
        return word;
    }

	public static void main(String[] args) {
		
		String s = "Hello, my name is John";
		
		String s1 =", , , ,        a, eaefa";
		
		System.out.println(new Segment434().countSegments(s));
		
		System.out.println(new Segment434().countSegments_leetcode(s1));
	}

}
