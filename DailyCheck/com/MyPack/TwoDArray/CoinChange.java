package DailyCheck.com.MyPack.TwoDArray;

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
	public static void main(String[] args) {
		
		int coins[] = { 9,6,5,1 };
        int n = coins.length;
        int sum = 11;
        System.out.println(coinChange(coins, n, sum));

	}

}
