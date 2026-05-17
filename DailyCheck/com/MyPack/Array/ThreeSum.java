package DailyCheck.com.MyPack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j,
 * i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * */
public class ThreeSum {

    static void ThreeSumImpl(int[] arr)
    {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            if(i>0 && arr[i-1]==arr[i])       // remove duplicate
                continue;
            int j=i+1,k=arr.length-1;
            while (j<k)
            {
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==0)
                {
                    res.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;
                    while (j<k && arr[j-1]==arr[j])        // remove duplicate
                        j++;
                }
                else if(sum<0)
                    j++;
                else k--;
            }
        }
        res.forEach(i-> System.out.println(i));
    }

    public static void main(String[] args)
    {
        int[] arr={-1,0,1,2,-1,-4};

        ThreeSumImpl(arr);
    }
}
