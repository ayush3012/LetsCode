package DailyCheck.com.MyPack.String;

public class LongestPalindromicSubsequence516 {

    static int LCSLength(String s,String t)
    {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=t.length();j++)
                dp[i][j]=s.charAt(i-1)==t.charAt(j-1)?1+dp[i-1][j-1]:Math.max(dp[i-1][j],dp[i][j-1]);
        return dp[s.length()][t.length()];
    }
    static int longestPalindromeSubseq(String s)
    {
        String t=new StringBuilder(s).reverse().toString();

        return LCSLength(s,t);
    }
    public static void main(String[] args) {

        String s="bbbab";

        System.out.println(longestPalindromeSubseq(s));
    }
}
