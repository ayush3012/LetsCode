package com.mypack.Array;

public class MergeTwoSortedArray {
	
	public static void Merge(int[] arr1,int m,int[] arr2,int n)
	{
		int[] arr=new int[m+n];
		while(m>0 && n>0)
			arr[m+n-1]=arr1[m-1]>arr2[n-1]?arr1[--m]:arr2[--n];
		while(m>0)
			arr[m+n-1]=arr1[--m];
		while(n>0)
			arr[m+n-1]=arr2[--n];
		
		for(int i:arr)
			System.out.print(i+" ");
	}

	public static void main(String[] args) {
		
		int[] arr1= {1,4,6,7};
		int[] arr2= {1,2,7,9};
		
		Merge(arr1, arr1.length, arr2, arr2.length);
		
	}

}
