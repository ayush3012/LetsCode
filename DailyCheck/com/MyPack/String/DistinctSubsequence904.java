package DailyCheck.com.MyPack.String;

public class DistinctSubsequence904 {

    public static int distinctSubseqII(String s) {
        final int MOD=1000000007;

        long[] dp=new long[s.length()+1];
        int[] last=new int[26];
        dp[0]=1;
        for(int i=1;i<=s.length();i++)
        {
            int idx=s.charAt(i-1)-'a';

            dp[i]=(2*dp[i-1])%MOD;

            if(last[idx]!=0)
                dp[i]=(dp[i]-dp[last[idx]-1]+MOD)%MOD;
            last[idx]=i;
        }
        return (int)((dp[s.length()]-1+MOD)%MOD);
    }
    public static void main(String[] args) {

        String s = "abc";

        System.out.println(distinctSubseqII(s));
    }
}
