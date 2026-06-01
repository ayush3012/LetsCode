package DailyCheck.com.MyPack.TwoDArray;

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
    public static void main(String[] args) {

        int egg=2;
        int floor=6;

        eggDropPuzzle(egg,floor);

    }
}
