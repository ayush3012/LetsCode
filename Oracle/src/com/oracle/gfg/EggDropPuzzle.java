package com.oracle.gfg;

public class EggDropPuzzle {
	
	public static int eggDrop(int egg,int floor)
	{
		if(egg==1)
			return floor;
		if(floor==0 || floor==1)
		    return floor;
		int min=Integer.MAX_VALUE;
		int temp,i;
		for(i=1;i<=floor;i++)
		{
		 temp=Math.max(eggDrop(egg-1, i-1), eggDrop(egg, floor-i));
		    if(min>temp)
			   min=temp;
		}
		
		return min+1;
		
	}

	public static void main(String[] args) {
		
		System.out.println(eggDrop(2, 10));
	}

}
