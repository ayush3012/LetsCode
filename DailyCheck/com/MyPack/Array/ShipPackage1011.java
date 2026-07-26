package DailyCheck.com.MyPack.Array;

public class ShipPackage1011 {

    static boolean canLift(int[] weights,int capacity,int days)
    {
        int day=1;
        int currWeight=0;
        for(int weight:weights)
        {
            currWeight+=weight;
            if(currWeight>capacity)
            {
                day++;
                currWeight=weight;
            }
        }
       return day<=days;
    }

    static void shipWithinDays(int[] weights,int days)
    {
        int l=weights[0];
        int r=weights[0];
        int ans=r;
        for(int i=1;i< weights.length;i++)
        {
            r+=weights[i];
            l=Math.max(l,weights[i]);
        }
        while (l<=r)
        {
            int capacity=l+(r-l)/2;
            if(canLift(weights,capacity,days))
            {
                ans=capacity;
                r=capacity-1;
            }else l=capacity+1;
        }
        System.out.println("Minimum capacity required: "+ans);
    }
    public static void main(String[] args) {
       int[] weights = {1,2,3,4,5,6,7,8,9,10};
       int days = 5;

       shipWithinDays(weights,days);
    }
}
