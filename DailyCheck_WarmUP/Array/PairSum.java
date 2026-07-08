package DailyCheck_WarmUP.Array;

import java.util.*;

public class PairSum {
	
	public static void method1(int[] arr,int k)
	{
		List<Integer> al=new ArrayList<>();
		int count=0;
		for(int i:arr)
		{
			if(al.contains(k-i))
			{
				System.out.println("found sum "+i+" and "+(k-i));
				count++;
			}
			al.add(i);
		}
		System.out.println("total pairs: "+count);
	}

	public static void method2(int[] arr,int k)
	{
		Arrays.sort(arr);
		int s=0;
		int e=arr.length-1;
		int count=0;
		while(s<e)
		{
			if(arr[s]+arr[e]==k)
			{
				System.out.println("sum found at "+s+" "+e);
				s++;
				e--;
				count++;
			}
			else if(arr[s]+arr[e]>k)
			{
				e--;
			}
			else if(arr[s]+arr[e]<k)
			{
				s++;
			}
		}
		System.out.println("total pairs: "+count);
	}

	static int[] twoSum_linearTime(int[] arr,int target)
	{
		Map<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			int complement=target-arr[i];
			if(hm.containsKey(complement))
				return new int[]{hm.get(complement),i};
			hm.put(arr[i],i);
		}
		return new int[]{-1,-1};
	}
	public static void main(String[] args) {
		
		int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        method1(arr,sum);System.out.println();
        method2(arr, sum);
		System.out.println();

		int[] arr2 = { 1, 5, 7, -1, 5 };
		System.out.println("Index of pair whose sum is: "+sum);
		for (int a:twoSum_linearTime(arr2,sum))
			System.out.print(a+" ");

	}

}
