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

	public static void StockBuyNSell_method2(int[] arr)
	{
		int buy=0;
		int buyind=0;
		int sell=0;
		int profit=0;
		int maxprofit=0;
		int minsofar=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			profit=arr[i]-minsofar;
			if(profit>maxprofit)
			{
				maxprofit=profit;
				buyind=buy;
				sell=i;
			}
			if(arr[i]<minsofar)
			{
				minsofar=arr[i];
				buy=i;
			}
		}
		System.out.println("Buy at "+buy+" sell at "+sell+" with profit "+maxprofit);
	}

	public static void main(String[] args) {
		
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		
		StockBuyNSell(price);

		StockBuyNSell_method2(price);

	}

}
