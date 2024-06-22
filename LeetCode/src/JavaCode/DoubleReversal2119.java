package JavaCode;
/*Reversing an integer means to reverse all its digits.
For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained.
Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2. Return true if
 reversed2 equals num. Otherwise return false.
 Input: num = 526
Output: true
Explanation: Reverse num to get 625, then reverse 625 to get 526, which equals num.*/
public class DoubleReversal2119 {
	
	public boolean isSameAfterReversals(int num) {

		return num==rev(rev(num));
	}
	public int rev(int num)
	{
		int res=0;
		while(num>0)
		{
			res=res*10+num%10;
			num/=10;
		}
		return res;
	}

	public static void main(String[] args) {
		int num = 526;
		//int num = 1800;
		//int num = 0;

		System.out.println(new DoubleReversal2119().isSameAfterReversals(num));
	}

}
