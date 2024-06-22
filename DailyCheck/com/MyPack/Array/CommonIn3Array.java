package com.mypack.Array;

public class CommonIn3Array {

	
	public static boolean BinarySearch(int[] arr,int n,int k)
	{
		int s=0;
		int e=n-1;
		while(s<=e)
		{
			int mid=(s+e)/2;
			if(arr[mid]==k)
				return true;
			else if(arr[mid]>k)
				e=mid-1;
			else if(arr[mid]<k)
				s=mid+1;
		}
		return false;
	}
	public static void Common(int[] arr1,int n1,int[] arr2,int n2,int[] arr3,int n3)
	{
		for(int i=0;i<n1;i++)
		{
			boolean b=(BinarySearch(arr2, n2, arr1[i]) && BinarySearch(arr3, n3, arr1[i]));
			if(b)
			  System.out.print(arr1[i]+" ");
		}
			
	}
	public static void main(String[] args) {
		
		int arr1[] = { 1, 5, 10, 20, 40, 80 };
        int arr2[] = { 6, 7, 20, 80, 100 };
        int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

        Common(arr1, arr1.length, arr2, arr2.length, arr3, arr3.length);
	}

}
