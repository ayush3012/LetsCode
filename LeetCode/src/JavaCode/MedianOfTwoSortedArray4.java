package LeetCode.src.JavaCode;

import java.util.Arrays;

public class MedianOfTwoSortedArray4 {

    static int[] merge(int[] nums1,int[] nums2)
    {
        int[] nums=new int[nums1.length+nums2.length];
        int i=nums1.length;
        int j=nums2.length;
        int k=nums.length;
        while(i>0 && j>0)
            nums[--k]=nums1[i-1]>=nums2[j-1]?nums1[--i]:nums2[--j];
        while (i>0)
            nums[--k]=nums1[--i];
        while (j>0)
            nums[--k]=nums2[--j];
        return nums;
    }
    static double findMedianSortedArrays(int[] nums1,int[] nums2)
    {
        int[] nums=merge(nums1,nums2);
        if(nums.length%2!=0)
            return 1.0*nums[nums.length/2];
        else {
            int r=nums.length/2;
            int l=r-1;
            return 1.0*(nums[l]+nums[r])/2;
        }
    }
    public static void main(String[] args) {
        int[] nums1 ={2,2,4,4};int[] nums2={2,2,2,4,4};

        int[] nums=merge(nums1,nums2);

        System.out.println(Arrays.toString(nums));

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
