package DailyCheck.com.MyPack.String;

public class EditDistance72 {

    static void edit(String s,String t)
    {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++)
        {
            for(int j=0;j<=t.length();j++)
            {
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else
                dp[i][j]=s.charAt(i-1)==t.charAt(j-1)?dp[i-1][j-1]:
                        1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        System.out.println("minimum operation needed:"+dp[s.length()][t.length()]);
    }
    public static void main(String[] args) {
        String s="horse";
        String t="ros";

        edit(s,t);
    }
}
