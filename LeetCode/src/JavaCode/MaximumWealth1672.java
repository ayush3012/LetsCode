package JavaCode;
/*Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.*/
public class MaximumWealth1672 {
	
	public int maximumWealth(int[][] accounts) {

		int max=Integer.MIN_VALUE;
		for(int[] arr:accounts)
		{
			int res=0;
			for(int a:arr)
				res+=a;
			max=Math.max(res, max);
		}
		return max;
	}

	public static void main(String[] args) {
		
		//int[][] accounts= {{1,2,3},{3,2,1}};
		//int[][] accounts= {{1,5},{7,3},{3,5}};
		int[][] accounts= {{2,8,7},{7,1,3},{1,9,5}};
		

		System.out.println(new MaximumWealth1672().maximumWealth(accounts));
	}

}
