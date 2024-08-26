package JavaCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
A subarray is a contiguous subsequence of the array.
 */
public class SumOfOddLengthSubarray1588 {

	public int sumOddLengthSubarrays(int[] arr) {

		List<int[]> result=new ArrayList<>();
		result=generateSubArray(arr);
		int sum=0;
		for(int[] ar:result)
		{
			for(int a:ar)
				sum+=a;
		}
		return sum;
	}

	public List<int[]> generateSubArray(int[] arr)
	{
		List<int[]> result=new ArrayList<>();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if((j-i+1)%2!=0)
				{
					int[] sub=new int[j-i+1];
					System.arraycopy(arr, i, sub, 0,j-i+1);
					result.add(sub);
				}
			}
		}
		return result;
	}
	
	public int sumOddLengthSubarrays_leetcode(int[] arr) {
        int sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int start = n - i;
            int end = i + 1;
            int totalPossibleSubArrs = start * end;
            int oddSubs = totalPossibleSubArrs / 2;
            if (totalPossibleSubArrs % 2 != 0) {
                oddSubs++;
            }
            sum += oddSubs * arr[i];
        }
        return sum;
    }

	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};

		System.out.println(new SumOfOddLengthSubarray1588().sumOddLengthSubarrays(arr));

	}

}
