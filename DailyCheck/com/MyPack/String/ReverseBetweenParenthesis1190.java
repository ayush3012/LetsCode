package DailyCheck.com.MyPack.String;

import java.util.Stack;

public class ReverseBetweenParenthesis1190 {

    static void reverse(String s)
    {
        Stack<String> stk=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                stk.push(sb.toString());
                sb.setLength(0);
            }else if(c==')')
            {
                sb.reverse();
                String pre=stk.pop();
                sb=new StringBuilder(pre+sb.toString());
            }else sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";

        reverse(s);
    }
}
