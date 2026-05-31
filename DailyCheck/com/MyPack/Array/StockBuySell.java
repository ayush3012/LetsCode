package DailyCheck.com.MyPack.Array;

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

	//If we want to store index
	static void StockBuySell(int[] arr)
	{
		int s=0;
		int buy=0;
		int sell=0;
		int min=arr[0];
		int profit=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
				s=i;
			}
			if(profit<arr[i]-min)
			{
				profit=arr[i]-min;
				buy=s;
				sell=i;
			}
		}
		System.out.println("for maximum profit buy at "+buy+" and sell at "+sell+" with profit "+profit);
	}

	public static void main(String[] args) {
		
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		
		StockBuyNSell(price);

		StockBuySell(price);

	}

}
