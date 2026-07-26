package DailyCheck.com.MyPack.Array;

public class KokoEatingBanana875 {

    static boolean canEat(int[] piles,int speed,int h)
    {
        int day=0;
        for(int p:piles)
        {
            day+=(p+speed-1)/speed;
            if(day>h)
                return false;
        }
        return true;
    }
    static void minEatingSpeed(int[] piles,int h)
    {
        int l=1,r=piles[0];
        for(int a:piles) r=Math.max(a,r);
        int ans=r;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(canEat(piles,mid,h))
            {
                ans=mid;
                r=mid-1;
            }else l=mid+1;
        }
        System.out.println("minimum eating spped: "+ans);
    }
    public static void main(String[] args) {

        int[] piles = {3,6,7,11};int h = 8;

        minEatingSpeed(piles,h);
    }
}
