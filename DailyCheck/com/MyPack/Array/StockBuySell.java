package com.mypack.Array;

public class StockBuySell {
	
	public static void StockBuyNSell(int[] arr)
	{
		int min_so_far=Integer.MAX_VALUE;
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			min_so_far=Math.min(min_so_far, arr[i]);
			int profit=arr[i]-min_so_far;
			max=Math.max(profit, max);
		}
		
		System.out.println("max profit "+max);
	}

	public static void main(String[] args) {
		
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		
		StockBuyNSell(price);	

	}

}
