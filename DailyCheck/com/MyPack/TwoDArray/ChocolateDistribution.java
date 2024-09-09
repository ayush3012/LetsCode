package com.mypack.TwoDArray;

import java.util.Arrays;

public class ChocolateDistribution {
	
	static int distributeChocolate(int[] packets,int student)
	{
		if(packets.length==0 || student==0)
			return 0;
		
		Arrays.sort(packets);
		
		if(packets.length-1<student)
			return -1;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<packets.length;i++)
		{
			int j=i+student-1;
			if(j>=packets.length)
				break;
			min=Math.min(min,packets[j]-packets[i]);
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;

        System.out.println(distributeChocolate(arr, m));
	}

}
