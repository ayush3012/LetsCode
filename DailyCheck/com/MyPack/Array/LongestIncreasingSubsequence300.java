package DailyCheck.com.MyPack.Array;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence300 {

    static int binarySearch(List<Integer> al, int num)
    {
        int l=0,r=al.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(al.get(mid)>num) r=mid-1;
            else if(al.get(mid)<num) l=mid+1;
            else return mid;
        }
        return l;
    }
    static void LIS(int[] nums)
    {
        List<Integer> al=new ArrayList<>();
        for(int a:nums)
        {
            int x=binarySearch(al,a);
            if(x==al.size())
                al.add(a);
            else al.set(x,a);
        }
        System.out.println(al.size());;
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        LIS(nums);
    }
}
