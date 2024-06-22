package com.mypack.Array;

public class RotateArray {
	
	public static int[] RotateArrayByk(int[] arr,int k)
	{
		while(k-->0)
		{
			int temp=arr[arr.length-1];
			for(int i=arr.length-2;i>=0;i--)
				arr[i+1]=arr[i];
			arr[0]=temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		
		
		int[] arr= {1,2,3,4,5,6,7,8,9};
		
		int k=3;
		arr=RotateArrayByk(arr, k);
		for(int i:arr)
		  System.out.print(i+" ");

	}

}
