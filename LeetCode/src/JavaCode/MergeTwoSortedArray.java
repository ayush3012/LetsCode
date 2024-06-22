package JavaCode;

public class MergeTwoSortedArray {

	private static int[] MTSA(int[] arr1,int[] arr2)
	{
		int m=arr1.length;
		int n=arr2.length;
		int[] arr=new int[m+n];
		int k=arr.length;
		while(n>0)
			arr[--k]=(m==0 || arr2[n-1]>arr1[m-1])?arr2[--n]:arr1[--m];
		arr[0]=arr1[0];
		return arr;
	}
	public static void main(String[] args) {
		
		int[] arr1= {1,4,6,8,9};
		int[] arr2= {2,4,5,7};
		int[] arr=new int[arr1.length+arr2.length];
		
		arr=MTSA(arr1, arr2);
		for(int i:arr)
			System.out.print(i+" ");

	}

}
