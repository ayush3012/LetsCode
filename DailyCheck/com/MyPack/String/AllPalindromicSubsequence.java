package DailyCheck.com.MyPack.String;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromicSubsequence {

    static boolean isPalindrome(String s)
    {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    static void generateAllPalindromicSubsequence(String s, int ind, StringBuilder curr, List<String> res)
    {
        if(s.length()==ind)
        {
            if(curr.length()>0 && isPalindrome(curr.toString()))
                res.add(curr.toString());
            return;
        }
        curr.append(s.charAt(ind));
        generateAllPalindromicSubsequence(s,ind+1,curr,res);
        curr.deleteCharAt(curr.length()-1);
        generateAllPalindromicSubsequence(s,ind+1,curr,res);
    }
    public static void main(String[] args) {
        String s="aba";

        List<String> res=new ArrayList<>(); // replace this with set to get unique result only

        generateAllPalindromicSubsequence(s,0,new StringBuilder(),res);

        System.out.println(res);
    }
}
