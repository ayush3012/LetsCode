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

    static int countPalindromicSubsequence(String s) // for leetcode, if we want only count
    {
        int n=s.length();
        long[][] dp=new long[n][n];

        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int len=2;len<=n;len++)
        {
            for(int i=0;i<=n-len;i++)
            {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
                else
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
            }
        }
        return (int)dp[0][n-1];
    }
    public static void main(String[] args) {
        String s="aba";

        List<String> res=new ArrayList<>(); // replace this with set to get unique result only

        generateAllPalindromicSubsequence(s,0,new StringBuilder(),res);

        System.out.println(res);

        System.out.println(countPalindromicSubsequence(s));
    }
}
