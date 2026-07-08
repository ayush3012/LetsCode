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

    static void decodeString(String s)
    {
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> strStack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
                num=num*10+(c-'0');
            else if(c=='[')
            {
                numStack.push(num);
                strStack.push(sb);
                num=0;
                sb=new StringBuilder();
            }
            else if(c==']')
            {
                int a=numStack.pop();
                StringBuilder x=strStack.pop();
                for(int j=0;j<a;j++)
                    x.append(sb);
                sb=x;
            }else sb.append(c);
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";

        reverse(s);

        String s1="3[a2[b3[c]]]";

        decodeString(s1);
    }
}
