package com.mypack.Array;

import java.util.Arrays;

public class NextGreaterNumber {
	public static int[] swap(int[] arr,int a,int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
		return arr;
	}
	
	public static void nextGreaterNumber(int[] arr)
	{
		int i;
		for(i=arr.length-1;i>=0;i--)
			if(arr[i-1]<arr[i])
				break;
		if(i==0)
			System.out.println("not possible");
		else
		{
			Arrays.sort(arr,i,arr.length);
			int k;
			for(k=i;k<arr.length;k++)
				if(arr[i-1]!=arr[k])
					break;
			arr=swap(arr,i-1,k);     // swap(arr,i-1,i); will not work if both are same
			Arrays.sort(arr,i,arr.length);
			for(int j:arr)
				System.out.print(j+" ");
		}
	}

	public static void main(String[] args) {
		
		//int[] arr= {1,2,3,6,8,7,6};  //1237668
		
		int[] arr= {5,3,4,9,7,6};     //5 3 6 4 7 9 
		
		nextGreaterNumber(arr);

	}

}
