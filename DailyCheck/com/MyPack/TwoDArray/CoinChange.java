package com.mypack.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
	
	static List<List<Integer>> coinChange(int[] coins,int n,int sum)
	{
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> combination=new ArrayList<>();
		coinHelper(coins,sum,0,combination,result);
		return result;
	}

	private static void coinHelper(int[] coins,int sum,int start,List<Integer> combination,List<List<Integer>> result)
	{
		if(sum==0)
		{
			result.add(new ArrayList<>(combination));
			return;
		}
		if(sum<0)
			return;
		for(int i=0;i<coins.length;i++)
		{
			combination.add(coins[i]);
			coinHelper(coins, sum-coins[i], i, combination, result);
			combination.remove(combination.size()-1);
		}
	}
	public static void main(String[] args) {
		
		int coins[] = { 9,6,5,1 };
        int n = coins.length;
        int sum = 11;
        System.out.println(coinChange(coins, n, sum));

	}

}
