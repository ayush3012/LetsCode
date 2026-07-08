package DailyCheck_WarmUP.Array;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubarrayWithGivenSum {
	
	public static int subArray(int[] arr,int k)
	{
		int window=0;
		int left=0;
		int ans=arr.length+1;
		for(int right=0;right<arr.length;right++)
		{
			 window+=arr[right];
			   while(window>k)
				   window-=arr[left++];
			   if(window==k)
				   ans=Math.min(right-left+1,ans);
		}
		return ans==arr.length+1?0:ans;
	}

	static void subArrayWithGivenSumMinLen(int[] arr,int k)
	{
		Map<Integer,Integer> hm=new HashMap<>();
		hm.put(0,-1);
		int s=0;
		int e=0;
		int window=0;
		int minLen=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			window+=arr[i];
			if(hm.containsKey(window-k))
			{
				int j=hm.get(window-k);
				if(i-j<minLen)
				{
					minLen=i-j;
					s=j+1;
					e=i;
				}
			}
			hm.put(window,i);
		}
		System.out.println("Minimum length subarray with sum: "+k+" found from "+s+" to "+e);
	}

	public static void main(String[] args) {
		
		int[] arr= {2,4,6,10,2,1};
		int k=12;

		System.out.println(subArray(arr, k));

		int[] arr2= {2,4,6,10,2,1,0,12};
		int k2=12;
		subArrayWithGivenSumMinLen(arr2,k2);
	}

}
