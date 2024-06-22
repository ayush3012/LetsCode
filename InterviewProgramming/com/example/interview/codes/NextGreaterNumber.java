package com.interview.codes;

import java.util.Arrays;

public class NextGreaterNumber {
	public static void swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void getNext(int[] arr)
	{
		int i;
		for(i=arr.length-1;i>0;i--)
			if(arr[i-1]<arr[i])
				break;
		if(i==0)
			System.out.println("NP");
		Arrays.sort(arr,i,arr.length);
		swap(arr,i-1,i);
		Arrays.sort(arr,i,arr.length);
		for(int k=0;k<arr.length;k++)
			System.out.print(arr[k]+" ");
			
	}
	public static void main(String[] args) {
		
		int[] arr= {1,2,3,4};
		//int[] arr= {5,3,4,9,7,6};
		getNext(arr);
		//534976
		/*
		 * 1.first find smaller number from right most which is small from right 
		 * 2.find next greater to the right of step no.1 
		 * 3.swap 1 and 2 
		 * 4.sort right to the 1.
		 */

	}

}
