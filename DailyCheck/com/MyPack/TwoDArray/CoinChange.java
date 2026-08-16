package DailyCheck.com.MyPack.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
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
		for(int i=start;i<coins.length;i++)
		{
			combination.add(coins[i]);
			coinHelper(coins, sum-coins[i], i, combination, result);
			//coinHelper(coins, sum-coins[i], i+1, combination, result);-> it will skip the current pile
			// if we have to find subset/combination then we can use this approach
			// not for subarray-> it is contigious and above approach chooses random element to make sum
			combination.remove(combination.size()-1);
		}
	}

	/*
	* 1. Create array of list . dp[i]-> store all combination that make sum
	* 2. Initialize each dp[i] with an empty arraylist. After this dp[0], dp[1] ...will exists and can
	*    store combination.
	* 3. outer for loop -> pick one coin at a time
	* 4. middle for loop try to build every amount using that coin
	* 5. extend every existing combination by adding that coin
	* */
	static void CoinChange_Method(int[] arr,int sum)
	{
		List<List<Integer>>[] dp=new ArrayList[sum+1];
		for(int i=0;i<=sum;i++)
			dp[i]=new ArrayList<>();
		dp[0].add(new ArrayList<>());
		for(int a:arr)
		{
			for(int i=a;i<=sum;i++)
			{
				for(List<Integer> pre:dp[i-a])
				{
					List<Integer> newComb=new ArrayList<>(pre); // TC O(n^2)
					newComb.add(a);
					dp[i].add(newComb);
				}
			}
		}
		for(List<Integer> comb:dp[sum])
			System.out.println(comb);
	}

	// leetcode322: find minimum number of coin to make sum
	static void coinChange322(int[] coins,int amount)
	{
		int[] dp=new int[amount+1];
		Arrays.fill(dp,amount+1);
		dp[0]=0;
		for(int i=1;i<=amount;i++)
		{
			for (int coin:coins)
			{
				if(i>=coin)
				  dp[i]=Math.min(dp[i],dp[i-coin]+1);
			}
		}
		System.out.println(dp[amount]>amount?-1:dp[amount]);
	}

	//leetcode518 total ways to make sum
	static void coinChange518(int amount,int[] coins)
	{
		int[] dp=new int[amount+1];
		dp[0]=1;
		for(int coin:coins)
		{
			for(int i=coin;i<=amount;i++)
				dp[i]+=dp[i-coin];
		}
		System.out.println(dp[amount]);
	}
	public static void main(String[] args) {
		
		int coins[] = { 9,6,5,1 };
        int n = coins.length;
        int sum = 11;
        System.out.println(coinChange(coins, n, sum));

		coinChange322(coins,sum);

		coinChange518(sum,coins);
	}

}
