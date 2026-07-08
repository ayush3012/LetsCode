package DailyCheck_WarmUP.Array;

import java.util.*;

public class SubArrayWithGivenSum {
	
	public static void SubArraySum(int[] arr,int k)
	{
		Map<Integer,Integer> map=new HashMap<>();
		int start=0;
		int end=-1;
		int sum=0;
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			if(sum==k)
			{
				start=0;
				end=i;
				count++;
				System.out.println("sum found b/w "+start+" to "+end);
			}
			if(map.containsKey(sum-k))
			{
				start=map.get(sum-k)+1;
				end=i;
				count++;
				System.out.println("sum found b/w "+start+" to "+end);
			}
			map.put(sum,i);
		}
		System.out.println("total subarray: "+count);
	}

	static void StoreAllSubarray(int[] arr,int sum)
	{
		Map<Integer,Integer> hm=new HashMap<>();
		hm.put(0,-1);
		List<int[]> al=new ArrayList<>();
		int window=0;
		for(int i=0;i<arr.length;i++)
		{
			window+=arr[i];
			if(hm.containsKey(window-sum))
			{
				int j=hm.get(window-sum)+1;
				al.add(Arrays.copyOfRange(arr,j,i+1));
			}
			hm.put(window,i);
		}
		for(int[] res:al)
			System.out.println(Arrays.toString(res));
	}

	static void leetcode_560(int[] nums,int k)
	{
		Map<Integer,Integer> hm=new HashMap();
		int sum=0,count=0;
		for(int a:nums)
		{
			sum+=a;
			count+=hm.getOrDefault(sum-k,0);
			hm.put(sum,hm.getOrDefault(sum,0)+1);
		}
		System.out.println("total subarray with sum "+k+" is: "+count);
	}
	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
        int sum = -10;
        
        SubArraySum(arr, sum);
		System.out.println();

		StoreAllSubarray(arr,sum);

		leetcode_560(arr,sum);
	}

}
