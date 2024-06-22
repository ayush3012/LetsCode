package com.interview.codes;

import java.util.Scanner;

public class MaxAndMinInArray {
	
	public static void MaxAndMin(int[] arr)
	{
		int min=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(min>arr[i])
				min=arr[i];
			if(max<arr[i])
				max=arr[i];
		}
		System.out.println("min :"+min+" max :"+max);
	}

	public static void main(String[] args) {
		
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length of an array:");
		n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=(int)(Math.random()*10);
		System.out.println("array is:: ");
		for(int i=0;i<n;i++)
		System.out.print(arr[i]+" ");
		System.out.println();
		MaxAndMin(arr);
		sc.close();

	}

}
