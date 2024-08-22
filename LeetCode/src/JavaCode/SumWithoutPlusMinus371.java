package JavaCode;

/**Given two integers a and b, return the sum of the two integers without using the operators + and -.*/

public class SumWithoutPlusMinus371 {

	public int getSum(int a, int b) {

		while(b!=0)
		{
			int sum= a^b;
			int car=(a & b) <<1;
			a=sum;
			b=car;
		}
		return a;
	}
	public static void main(String[] args) {
		int a = 1;int b = 2;

		System.out.println(new SumWithoutPlusMinus371().getSum(a, b));

	}

}
