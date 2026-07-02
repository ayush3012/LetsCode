package LeetCode.src.JavaCode;

public class KokoEatBanana875 {

    static boolean canFinish(int[] piles,int h,int speed)
    {
        int eat=0;
        for(int a:piles)
        {
            eat+=(a+speed-1)/speed;
            if(eat>h)
                return false;
        }
        return true;
    }

    static int minEatingSpeed(int[] piles,int h)
    {
        int l=1,r=0;
        for(int a:piles) r=Math.max(r,a);
        int answer=r;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(canFinish(piles,h,mid))
            {
                answer=mid;
                r=mid-1;
            }else l=mid+1;
        }
        return answer;
    }
    public static void main(String[] args) {

        int[] piles = {3,6,7,11};int h = 8;

        System.out.println(minEatingSpeed(piles,h));
    }
}
