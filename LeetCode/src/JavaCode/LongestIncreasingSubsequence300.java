package LeetCode.src.JavaCode;

import InterviewProgramming.com.interview.codes.Practice;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence300 {

    public int lengthOfLIS(int[] nums) {

        if(nums.length==0)
            return 0;
        List<Integer> al=new ArrayList<>();
        for(int i:nums)
        {
            int x=binarySearch(al, i);
            if(x==al.size())
                al.add(i);
            else
                al.set(x, i);
        }
        return al.size();
    }

    public int binarySearch(List<Integer> al,int num)
    {
        int left=0;int right=al.size()-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(al.get(mid)>num)
                right=mid-1;
            else if(al.get(mid)<num)
                left=mid+1;
            else
                return mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(nums));
    }
}
