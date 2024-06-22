package com.mypack.Misc;

public class SquareRoot {
	
	public static int root(int n)
	{
		if(n<2)
			return n;
		int s=1;
		int e=n/2;
		while(s<=e)
		{
			int mid=(s+e)/2;
			if(mid*mid>n)
			    e=mid-1;
			else if(mid*mid<n)
				s=mid+1;
			else if(mid*mid==n)
				return mid;
		}
		return e;
	}

	public static void main(String[] args) {

		System.out.println(root(49));
	}

}
