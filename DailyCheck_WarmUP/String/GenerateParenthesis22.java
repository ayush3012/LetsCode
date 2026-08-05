package DailyCheck_WarmUP.String;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {

    static void backtrack(int n,int open,int close,StringBuilder comb,List<String> res)
    {
        if(comb.length()==2*n)
        {
            res.add(comb.toString());
            return;
        }
        if(open<n)
        {
            comb.append("(");
            backtrack(n,open+1,close,comb,res);
            comb.deleteCharAt(comb.length()-1);
        }
        if(close<open)
        {
            comb.append(")");
            backtrack(n,open,close+1,comb,res);
            comb.deleteCharAt(comb.length()-1);
        }
    }
    public static List<String> generateParenthesis(int n) {

        List<String> res=new ArrayList<>();

        backtrack(n,0,0,new StringBuilder(),res);

        return res;
    }
    public static void main(String[] args) {

        generateParenthesis(2).forEach(i-> System.out.println(i));
    }
}
