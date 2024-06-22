package JavaCode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int closestSum(int[] arr,int tar)
	{
		int d=Integer.MAX_VALUE;
		int res=0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			int l=i+1;
			int h=arr.length-1;
			while(l<h) {
				int s=arr[i]+arr[l]+arr[h];
				if(Math.abs(s-tar)<d)
				{
					d=Math.abs(s-tar);
					res=s;
				}
				if(s>tar)
					h--;
				else if(s<tar)
					l++;
				else
					break;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int[] arr= {-1,2,1,-4};
		int target=1;

		System.out.println(closestSum(arr, target));
	}

}
