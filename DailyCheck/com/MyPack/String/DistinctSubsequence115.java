package DailyCheck.com.MyPack.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctSubsequence115 {

    static void backtrack(String s,String t,int ind,StringBuilder comb,List<String> res)
    {
        if(t.equals(comb.toString()))
        {
            res.add(comb.toString());
            return;
        }
        if(ind>=s.length())
            return;
        comb.append(s.charAt(ind));
        backtrack(s,t,ind+1,comb,res);
        comb.deleteCharAt(comb.length()-1);
        backtrack(s,t,ind+1,comb,res);
    }
    public static int numDistinct_mySolution(String s, String t) {

        List<String> res=new ArrayList<>();
        backtrack(s,t,0,new StringBuilder(),res);

        return res.size();
    }
  /*above approach is not working , giving TLE*/

    public static int numDistinct(String s, String t) {

        long[][] dp=new long[s.length()][t.length()];
        for(long[] row:dp)
            Arrays.fill(row,-1);

        return (int) solve(dp,s,t,0,0);
    }
    static long solve(long[][] dp,String s,String t,int i,int j)
    {
        if(j==t.length())
            return 1;
        if(i==s.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        long ans=solve(dp,s,t,i+1,j);
        if(s.charAt(i)==t.charAt(j))
            ans+=solve(dp,s,t,i+1,j+1);
        return dp[i][j]=ans;
    }

    public static int numDistinct_otherSolution(String s, String t) {
        int[] curr=new int[t.length()+1];curr[t.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=0;j<t.length();j++){
                curr[j]=s.charAt(i)==t.charAt(j)?curr[j]+curr[j+1]:curr[j];
            }
        }
        return curr[0];
    }
    public static void main(String[] args) {

        //String s = "rabbbit", t = "rabbit";

        String s = "babgbag", t = "bag";

        System.out.println(numDistinct(s,t));

        System.out.println(numDistinct_otherSolution(s,t));
    }
}
