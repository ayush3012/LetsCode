package com.mypack.Array;

public class ReplaceEveryK {

	public static int Replacek(int[] arr,int k)
	{
		int ind=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=k)
			{
				arr[ind]=arr[i];
				ind++;
			}
		}
		return ind;
	}
	public static void main(String[] args) {
		
		int[] arr= {4,3,2,2,3,3,1,5,3,9};
		
		int idx=Replacek(arr, 3);
		for(int i=0;i<idx;i++)
			System.out.print(arr[i]+" ");
	}

}
