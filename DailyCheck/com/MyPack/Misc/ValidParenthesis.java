package DailyCheck.com.MyPack.Misc;

import java.util.Stack;

public class ValidParenthesis {

    static boolean isValidParenthesis(String s)
    {
        Stack<Character> stk=new Stack<>();

        for(char c:s.toCharArray())
        {
            if(c=='(' || c=='{' || c=='[')
                stk.push(c);
            else if(stk.isEmpty()              ||
                    (c==')' && stk.pop()!='(') ||
                    (c=='}' && stk.pop()!='{') ||
                    (c==']' && stk.pop()!='[')  )
                return false;
        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        String s="(";

        System.out.println(isValidParenthesis(s));
    }
}
