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

	static void reverse(int[] arr,int s,int e)
	{
		while (s<e)
		{
			int temp=arr[s];
			arr[s]=arr[e];
			arr[e]=temp;
			s++;e--;
		}
	}

	static void rotateArrayByK(int[] arr,int k)
	{
		k=k%arr.length;
		reverse(arr,0,arr.length-1);
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
	}
	public static void main(String[] args) {
		
		
		int[] arr= {1,2,3,4,5,6,7,8,9};
		
		int k=3;
		/*arr=RotateArrayByk(arr, k);
		for(int i:arr)
		  System.out.print(i+" ");*/

		rotateArrayByK(arr,2);
		for (int a:arr)
			System.out.print(a+" ");

	}

}
