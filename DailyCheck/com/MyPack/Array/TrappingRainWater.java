package com.mypack.Array;

public class TrappingRainWater {
	
	public static void TrapWater(int[] arr)
	{
		int[] l=new int[arr.length];
		int[] r=new int[arr.length];
		
		l[0]=arr[0];
		r[arr.length-1]=arr[arr.length-1];
		
		int water=0;
		
		for(int i=1;i<arr.length;i++)
			l[i]=Math.max(l[i-1],arr[i]);
		for(int i=arr.length-2;i>=0;i--)
			r[i]=Math.max(r[i+1],arr[i]);
		
		for(int i=0;i<arr.length;i++)
			water+=Math.min(l[i],r[i])-arr[i];
		
		System.out.println("stored water "+water);
	}

	public static void main(String[] args) {
		

		//int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] arr = { 1, 1 };
		
		TrapWater(arr);
	}

}
