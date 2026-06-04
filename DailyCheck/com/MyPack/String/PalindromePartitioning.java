package DailyCheck.com.MyPack.String;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    static void backtrack(String str,int start,boolean[][] dp,List<String> comb,List<List<String>> res)
    {
        if(start==str.length())
        {
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int e=0;e<str.length();e++)
        {
            if(dp[start][e])
            {
                comb.add(str.substring(start,e+1));
                backtrack(str,start+1,dp,comb,res);
                comb.remove(comb.size()-1);
            }
        }
    }
    static void generatePalindrome(String str)
    {
        boolean[][] dp=new boolean[str.length()][str.length()];
        for(int i=str.length()-1;i>=0;i--)
        {
            for(int j=i;j<str.length();j++)
                dp[i][j]=str.charAt(i)==str.charAt(j) && (j-i<2 || dp[i+1][j-1]);
        }
        List<List<String>> res=new ArrayList<>();
        backtrack(str,0,dp,new ArrayList<>(),res);
        for(List<String> al:res)
            System.out.println(al);
    }
    public static void main(String[] args) {
        String str="ababa";

        generatePalindrome(str);

    }
}
