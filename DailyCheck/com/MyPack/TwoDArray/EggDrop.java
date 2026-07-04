package DailyCheck.com.MyPack.TwoDArray;

import java.util.Arrays;

public class EggDrop {

    static void eggDropPuzzle(int egg,int floor)
    {
        long[] dp=new long[egg+1];

        int moves=0;
        while (dp[egg]<floor)
        {
            moves++;
            for(int e=egg;e>=1;e--)
                dp[e]=dp[e]+dp[e-1]+1;
        }
        System.out.println(moves);
    }

    static int secondApproach(int egg,int floor,int[][] dp)
    {
        if(floor==0 || floor==1)
            return floor;
        if(egg==1)
            return floor;
        if(dp[egg][floor]!=-1)
            return dp[egg][floor];

        int l=1,h=floor,ans=Integer.MAX_VALUE;
        while (l<=h)
        {
            int mid=(l+h)/2;
            int breakCase=dp[egg-1][mid-1]!=-1?dp[egg-1][mid-1]:secondApproach(egg-1,mid-1,dp);
            int notBreakCase=dp[egg][floor-mid]!=-1?dp[egg][floor-mid]:secondApproach(egg,floor-mid,dp);

            int worst=1+Math.max(breakCase,notBreakCase);

            ans=Math.min(ans,worst);

            if(breakCase<notBreakCase) l=mid+1;
            else h=mid-1;
        }
        return dp[egg][floor]=ans;
    }
    public static void main(String[] args) {

        int egg=2;
        int floor=6;

        eggDropPuzzle(egg,floor);

        int[][] dp=new int[egg+1][floor+1];

        for(int i=0;i<=egg;i++)
            Arrays.fill(dp[i],-1);

        System.out.println(secondApproach(egg,floor,dp));
    }
}
