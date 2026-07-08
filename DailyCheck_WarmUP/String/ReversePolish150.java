package DailyCheck_WarmUP.String;

import java.util.Stack;

public class ReversePolish150 {

    static void reversePolish(String[] strs)
    {
        Stack<Integer> stk=new Stack<>();
        for(String s:strs)
        {
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))
            {
                int a=stk.pop();
                int b=stk.pop();
                if(s.equals("+"))  stk.push(a+b);
                else if (s.equals("-")) stk.push(b-a);
                else if(s.equals("/")) stk.push(b/a);
                else stk.push(a*b);
            }else{
                int a=Integer.valueOf(s);
                stk.push(a);
            }
        }
        System.out.println(stk.pop());
    }
    public static void main(String[] args) throws Exception {

        //String[] tokens = {"2","1","+","3","*"};

        String[] tokens = {"4","13","5","/","+"};

        reversePolish(tokens);

    }
}
