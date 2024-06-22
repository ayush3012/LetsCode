package JavaCode;

import java.util.Stack;

/*You are given a 0-indexed string word.

In one operation, you can pick any index i of word and change word[i] to any lowercase English letter.

Return the minimum number of operations needed to remove all adjacent almost-equal characters from word.

Two characters a and b are almost-equal if a == b or a and b are adjacent in the alphabet.
Example 1:

Input: word = "aaaaa"
Output: 2
Explanation: We can change word into "acaca" which does not have any adjacent almost-equal characters.
It can be shown that the minimum number of operations needed to remove all adjacent almost-equal characters from word is 2.*/
public class RemoveAlmostEqual2957 {
	
   public int removeAlmostEqualCharacters(String word) {
        
	   Stack<Character> stk=new Stack<>();
	   int count=0;
	   for(int i=0;i<word.length();i++)
	   {
		   if(!stk.isEmpty() && Math.abs(stk.peek()-word.charAt(i))<2)
		   {
			   count++;i++;
			   if(i==word.length())
				   i=i-1;
		   }
		   stk.push(word.charAt(i));
	   }
	   return count;
    }
   public int removeAlmostEqualCharacters_leetcode(String word) {
       
	   int count=0;
       for(int i=0;i<word.length()-1;)
       {
           char c=word.charAt(i);
           char d=word.charAt(i+1);
           if(Math.abs(c-d)<2)
           {
               count++;
               i+=2;
           }
           else
           {
               i++;
           }
       }
       return count;
    }
   
   public int removeAlmostEqualCharacters_leetcodeBest(String word) {
       int ct=0;
       for(int i=0;i<word.length()-1;i++)
       {
           if(word.charAt(i)+1==word.charAt(i+1)||word.charAt(i)==word.charAt(i+1)||word.charAt(i)-1==word.charAt(i+1))
       {
           ct++;
           i++;
       }
       }
       return ct;
   }

	public static void main(String[] args) {
		
		String s="aaaaa";
		//String s="abddez";
		//String s="zyxyxyz";
		//String s="aa";
		//String s="acb";
		
		//System.out.println(new RemoveAlmostEqual2957().removeAlmostEqualCharacters(s));
		
		System.out.println(new RemoveAlmostEqual2957().removeAlmostEqualCharacters_leetcode(s));

	}

}
