package com.example.sorting;

public class MergeSort {

	public static void mergeSort(int[] arr,int s,int e)
	{
		int mid=(s+e)/2;
		if(s<e)
		{
			mergeSort(arr, s, mid);
			mergeSort(arr, mid+1, e);
		}
		int i=0;
		int f=s;
		int l=mid+1;
		int[] res=new int[e-s+1];
		while(f<=mid && l<=e)
			res[i++]=arr[f]>=arr[l]?arr[l++]:arr[f++];
		while(f<=mid)
			res[i++]=arr[f++];
		while(l<=e)
			res[i++]=arr[l++];
		i=0;
		while(s<=e)
			arr[s++]=res[i++];
			
	}
	public static void main(String[] args) {
		
		int[] arr= {9,4,7,1,3,2,8};

		mergeSort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

}
