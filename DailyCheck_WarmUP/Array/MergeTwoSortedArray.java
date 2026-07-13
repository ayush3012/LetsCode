package DailyCheck_WarmUP.Array;

import java.util.Arrays;

public class MergeTwoSortedArray {
	
	public static void Merge(int[] arr1,int m,int[] arr2,int n)
	{
		int[] arr=new int[m+n];
		while(m>0 && n>0)
			arr[m+n-1]=arr1[m-1]>arr2[n-1]?arr1[--m]:arr2[--n];
		while(m>0)
			arr[m+n-1]=arr1[--m];
		while(n>0)
			arr[m+n-1]=arr2[--n];
		
		for(int i:arr)
			System.out.print(i+" ");
	}

	public static void merge_NoExtraSpace(int[] arr3,int[] arr4)
	{
		int i=arr3.length-arr4.length,j=arr4.length,k=arr3.length;
		while(i>0 && j>0) arr3[--k]=arr3[i-1]>arr4[j-1]?arr3[--i]:arr4[--j];
		while (i>0) arr3[--k]=arr3[--i];
		while (j>0) arr3[--k]=arr4[--j];

		System.out.println(Arrays.toString(arr3));
	}
	public static void main(String[] args) {
		
		int[] arr1= {1,4,6,7};
		int[] arr2= {1,2,7,9};

		int[] arr3= {1,4,6,7,0,0,0,0};
		int[] arr4= {1,2,7,9};
		
		Merge(arr1, arr1.length, arr2, arr2.length);

		System.out.println();
		merge_NoExtraSpace(arr3,arr4);
		
	}

}
