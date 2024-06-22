package JavaCode;


/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
**/
public class ClimbStairs {
	
	
	private static int climbStairs(int n)
	{
		if(n<=2)
			return n;
		int a=1;
		int b=2;
		for(int i=3;i<=n;i++)
		{
			int sum=a+b;  
			a=b;          
			b=sum;
		}
		return b;
	}

	public static void main(String[] args) {

		System.out.println(climbStairs(3));
	}

}
