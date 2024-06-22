package JavaCode;

import java.util.Arrays;

public class PlusOne {
	
	public static int[] plusOne(int[] digits)
	{
		int k=digits.length;
		int ln=k+1;
		int car=1;
		int[] arr=new int[ln];
		while(k-->0)
		{
			arr[--ln]=(digits[k]+car)%10;
			car=(digits[k]+car)/10;
		}
		if(car!=0)
			arr[0]=1;
		if(arr[0]==0)
			arr=Arrays.copyOfRange(arr,1, arr.length);
		return arr;
	}

	public static void main(String[] args) {

		//int[] arr= {1,2,3,4,5,6};
		int[] arr= {9};
		arr=plusOne(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

}
