package com.mypack.Array;

public class SearchInRotatedSortedArray {

	public static int EnhancedBinarySearch(int[] arr,int k)
	{
		int l=0;
		int h=arr.length-1;
		while(l<=h)
		{
			int mid=(l+h)/2;
			if(arr[mid]==k)
				return mid;
			if(arr[l]<=arr[mid])
			{
				if(arr[l]<=k && k<=arr[mid])
					h=mid-1;
				else
					l=mid+1;
			}
			else
			{
				if(arr[mid]<=k && k<=arr[h])
					l=mid+1;
				else
					h=mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
		int[] arr = {4,5,6,7,8,9,2,3};

		System.out.println(EnhancedBinarySearch(arr, 8));
	}

}
