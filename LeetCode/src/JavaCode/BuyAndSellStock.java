package JavaCode;

public class BuyAndSellStock {
	
	public static void profitized(int[] prices)
	{
		int min_so_far=prices[0];
		int max_profit=0;
		for(int i=1;i<prices.length;i++)
		{
			min_so_far=Math.min(min_so_far, prices[i]);
			int profit=prices[i]-min_so_far;
			max_profit=Math.max(max_profit,profit);
		}
		System.out.println("max profit "+max_profit);
	}

	public static void main(String[] args) {

	}

}
