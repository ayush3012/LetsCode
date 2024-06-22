package JavaCode;

/*Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
*/
public class PiovtInteger2485 {

	public int pivotInteger(int n) {

		int totalSum = n * (n + 1) / 2;
		int leftSum = 0;
		for (int i = 1; i <= n; i++) {
			if (leftSum == totalSum - leftSum - i)
				return i;
			leftSum+=i;
		}

		return -1;
	}

	public static void main(String[] args) {
		
		System.out.println(new PiovtInteger2485().pivotInteger(8));

	}

}
