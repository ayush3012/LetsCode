package com.mypack.Array;

import java.util.Arrays;

public class AddOneInArray {
	
	public static int[] AddOneInNumberRepresentedByArray(int[] arr)
	{
		int m=arr.length;
		int[] arr2=new int[m+1];
		int n=arr2.length-1;
		int sum=1;
		for(int i=m-1;i>=0;i--)
		{
			arr2[n--]=(arr[i]+sum)%10;
			sum=(arr[i]+sum)/10;
		}
		if(sum!=0)
			arr2[0]=sum;
		return arr2[0]==0?Arrays.copyOfRange(arr2, 1, arr2.length):arr2;
	}

	public static void main(String[] args) {
		
		int[] arr= {1,2,2,9};

		int[] arr2=new int[arr.length];
		
		arr2=AddOneInNumberRepresentedByArray(arr);
		for(int i:arr2)
			System.out.print(i+" ");
	}

}
