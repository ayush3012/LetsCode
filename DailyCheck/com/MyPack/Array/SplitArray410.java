package DailyCheck.com.MyPack.Array;

public class SplitArray410 {

    static boolean canSplit(int[] nums,int k,int max)
    {
        int sum=0,count=1;
        for(int a:nums)
        {
            if(sum+a>max)
            {
                count++;
                sum=a;
            }else sum+=a;
        }
        return count<=k;
    }

    static int splitArray(int[] nums,int k)
    {
        int l=0,r=0,ans=0;
        for(int a:nums)
        {
            l=Math.max(l,a);
            r+=a;
        }
        while (l<=r)
        {
            int mid=l+(r-l)/2;
            if(canSplit(nums,k,mid))
            {
                r=mid-1;
                ans=mid;
            }else l=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};int k = 2;

        System.out.println(splitArray(nums,k));
    }
}
