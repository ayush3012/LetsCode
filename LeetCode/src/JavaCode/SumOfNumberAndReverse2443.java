package JavaCode;

/*Given a non-negative integer num, return true if num can be expressed as the sum of any non-negative integer
 *  and its reverse, or false otherwise.
 *  Input: num = 443
Output: true
Explanation: 172 + 271 = 443 so we return true.*/
public class SumOfNumberAndReverse2443 {

	public boolean sumOfNumberAndReverse(int num) {
		 if(num==0)
	           return true;
	        for(int i=1;i<num;i++)
				if(i+reverse(i)==num)
					return true;
			return false;
			
	}
	public int reverse(int i)
	{
		int res=0;
		while(i!=0)
		{
			res=res*10+i%10;
			i/=10;
		}
		return res;
	}
	public static void main(String[] args) {
		//int num = 443;
		//int num=63;
		int num=181;
        System.out.println(new SumOfNumberAndReverse2443().sumOfNumberAndReverse(num));
	}

}
