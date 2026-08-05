package DailyCheck_WarmUP.String;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination17 {

    static final String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static void backtrack(String[] map, String digits, int ind, StringBuilder comb, List<String> res)
    {
        if(ind==digits.length())
        {
            res.add(comb.toString());
            return;
        }
        String l=map[digits.charAt(ind)-'0'];
        for(int i=0;i<l.length();i++)
        {
            comb.append(l.charAt(i));
            backtrack(map,digits,ind+1,comb,res);
            comb.deleteCharAt(comb.length()-1);
        }
    }

    public static List<String> letterCombinations(String digits) {
       if(digits==null || digits.isEmpty())
           return null;

       List<String> res=new ArrayList<>();

       backtrack(map,digits,0,new StringBuilder(),res);

       return res;
    }
    public static void main(String[] args) {

        letterCombinations("23").forEach(i-> System.out.println(i));
    }
}
