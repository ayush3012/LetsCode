package JavaCode;

import java.util.*;
/**You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.*/
public class ParanthesesStringReverse1190 {
	
	public String reverseParentheses(String s) {
		
		Stack<StringBuilder> stk=new Stack<>();
		StringBuilder curr=new StringBuilder();
		for(char c:s.toCharArray())
		{
			if(c=='(')
			{
				stk.push(curr);
				curr=new StringBuilder();
			}
			else if(c==')')
			{
				curr.reverse();
				curr=stk.pop().append(curr);
			}
			else
			{
				curr.append(c);
			}
		}
		return curr.toString();
	}

	public static void main(String[] args) {
		
		String s = "(ed(et(oc))el)";
		
		System.out.println(new ParanthesesStringReverse1190().reverseParentheses(s));

	}

}
