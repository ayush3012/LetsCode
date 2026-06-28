package DailyCheck.com.MyPack.Array;

import java.util.Arrays;

public class SubArrayMaxSum {
	
	public static void SubArrayMaxSum(int[] arr)
	{
		int max_so_far=0;
		int max=Integer.MIN_VALUE;
		int s=0;
		int e=-1;
		int start=0;
		for(int i=0;i<arr.length;i++)
		{
			max_so_far=max_so_far+arr[i];
			if(max<max_so_far)
				{
				  max=max_so_far;
				  start=s;
				  e=i;
				 }
			if(max_so_far<0)
			{
				max_so_far=0;
				s=i+1;
			}
		}
		System.out.println("subarray with maximum contigious sum "+max+" found b/w "+start+" to "+e);
	}

 // More efficient Kadane's Algo which handle all negative numbers
	static void KadaneAlgo(int[] arr)
	{
		int maxSum=arr[0];
		int currSum=arr[0];
		int st=0,start=0,end=0;

		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>currSum+arr[i])
			{
				currSum=arr[i];
				st=i;
			}else {
				currSum+=arr[i];
			}

			if(currSum>maxSum)
			{
				maxSum=currSum;
				start=st;
				end=i;
			}
		}
		System.out.println("Subarray with max sum is: "+maxSum+" from :"+start+" to "+end);
	}

	static void max_sum_Kadane(int[] arr)
	{
		int curr=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			curr=Math.max(arr[i],curr+arr[i]);
			max=Math.max(max,curr);
		}
		System.out.println("max sum:"+max);
	}
	public static void main(String[] args) {
		
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		
		//int[] arr = { 1,2,3,-4,-5,6,7 };
		
		SubArrayMaxSum(arr);

		int[] arr2 = { -2, -3, -4, -1, -2, -1, -5, -3 };

		KadaneAlgo(arr2);

		KadaneAlgo(arr);

		max_sum_Kadane(arr);

		max_sum_Kadane(arr2);
	}

}
