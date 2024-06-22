package com.mypack.Array;


/*Input:
N = 4
arr[] = {0, 0, 0, 0}
Output:
10
Explanation:
Following are the subarrays of
length 1: {0}, {0}, {0}, {0} - 4
length 2: {0, 0}, {0, 0}, {0, 0} - 3
length 3: {0, 0, 0}, {0, 0, 0} - 2
length 4: {0, 0, 0, 0} - 1
Total Subarrays: 4 + 3 + 2 + 1 = 10
*/
public class NumberOfSubarrayOfZero {
	
	public static long NumberOfSubarray(int[] arr)
	{
		long res=0;
		long len=0;
		for(int i=0;i<arr.length;i++)
			if(arr[i]==0)
				res+=++len;
			else
				len=0;
		return res;
	}

	public static void main(String[] args) {
		
		int arr[] = {0, 0, 0, 0};
		
		System.out.println(NumberOfSubarray(arr));

	}

}
