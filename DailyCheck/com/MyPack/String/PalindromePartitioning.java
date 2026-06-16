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
        for(int e=start;e<str.length();e++)
        {
            if(dp[start][e])
            {
                comb.add(str.substring(start,e+1));
                backtrack(str,e+1,dp,comb,res);
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

        /*
        * if we want all in one single set with no duplicate
        *  Set<String> set=new HashSet();
        * for(List<String> a:res)
        *   set.addAll(a);
        * System.ou.println(set);
        * */
    }

    static void countOnlyPartition(String s)
    {
        boolean[][] pal=new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i;j<s.length();j++)
                pal[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2 || pal[i+1][j-1]);

        long[] dp=new long[s.length()+1];
        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i;j<s.length();j++)
                if(pal[i][j])
                    dp[i]+=dp[j+1];

        System.out.println(dp[0]);
    }
    public static void main(String[] args) {
        String str="ababa";

        generatePalindrome(str);

        System.out.println();

        countOnlyPartition(str);

    }
}
