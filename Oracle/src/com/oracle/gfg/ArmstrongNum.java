package com.oracle.gfg;

public class ArmstrongNum {
	
	public static boolean isArmstrong(int a)
	{
		int temp=a;
		int sum=0;
		while(temp>0)
		{
			int x=temp%10;
			sum+=x*x*x;
			temp=temp/10;
		}
		return sum==a;
	}

	public static void main(String[] args) {
		
		int a=153;
		System.out.println(isArmstrong(a));
	}

}
