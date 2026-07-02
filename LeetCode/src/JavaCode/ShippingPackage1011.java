package LeetCode.src.JavaCode;

public class ShippingPackage1011 {

    static boolean canLift(int[] weights,int days,int capacity)
    {
        int usedDays=1;
        int currCapacity=0;
        for(int w:weights)
        {
            if(currCapacity+w<=capacity)
                currCapacity+=w;
            else {
                currCapacity=w;
                usedDays++;
            }
            if(usedDays>days)
                return false;
        }
        return true;
    }
    static void shipWithinDays(int[] weights,int days)
    {
        int l=0,r=0;
        for(int w:weights)
        {
            l=Math.max(l,w);
            r+=w;
        }
        int answer=r;
        while (l<=r)
        {
            int mid=l+(r-l)/2;
            if(canLift(weights,days,mid))
            {
                answer=mid;
                r=mid-1;
            }else l=mid+1;
        }
        System.out.println("minimum capacity required:"+answer);
    }
    public static void main(String[] args) {

        int[] weights={1,2,3,4,5,6,7,8,9,10};int days=5;

        shipWithinDays(weights,days);
    }
}
