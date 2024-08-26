package JavaCode;


/**Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 * */
public class OddNumber1523 {

	public int countOdds(int low, int high) {

		if(high%2==0 && low %2==0)
			return (high-low)/2;
		return (high-low)/2+1;
	}
	public static void main(String[] args) {

		int low = 3;int high = 7;

		System.out.println(new OddNumber1523().countOdds(low, high));

	}

}
