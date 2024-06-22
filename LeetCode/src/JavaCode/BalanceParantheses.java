package JavaCode;

import java.util.Stack;

public class BalanceParantheses {

	public static boolean isValid(String str)
	{
		Stack<Character> stk=new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(c=='(' || c=='{' || c=='['  )
				{
				  stk.push(c);
				  continue;
				}
			if(stk.isEmpty())
				return false;
			switch(c) {
			case ')':
				if(stk.peek()=='(')
				{
					stk.pop();
					break;
				}
				else
					return false;
			case ']':
				if(stk.peek()=='[')
				{
					stk.pop();
					break;
				}
				else
					return false;
			case '}':
				if(stk.peek()=='}')
				{
					stk.pop();
					break;
				}
				else
					return false;
			}
		}
		return stk.isEmpty();
		
	}
	public static void main(String[] args) {
		
		String str="()";
		System.out.println(isValid(str));
	}

}
