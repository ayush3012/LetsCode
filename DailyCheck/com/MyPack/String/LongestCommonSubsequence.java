package DailyCheck.com.MyPack.String;

public class LongestCommonSubsequence {

    static void LCSImpl(String s1,String s2)
    {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++)
            for(int j=1;j<=s2.length();j++)
                dp[i][j]=s1.charAt(i-1)==s2.charAt(j-1)?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);

        int i=s1.length();
        int j=s2.length();
        StringBuilder sb=new StringBuilder();
        while (i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                sb.append(s1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>=dp[i][j-1])
                i--;
            else j--;
        }
        System.out.println(sb.reverse() +" with length "+dp[s1.length()][s2.length()]);
    }

    public static void main(String[] args)
    {
        String s1="abcde";
        String s2="ace";

        LCSImpl(s1,s2);
    }
}
