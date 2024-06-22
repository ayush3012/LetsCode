package JavaCode;

/*Input: num = 240, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "24" from "240": 24 is a divisor of 240.
- "40" from "240": 40 is a divisor of 240.
Therefore, the k-beauty is 2.*/
public class KBeautyNumber2269 {

	public int divisorSubstrings(int num, int k) {

		String s = "" + num;
		int count = 0;
		for (int i = 0; i < s.length() - k + 1; i++) {
			int a = Integer.valueOf(s.substring(i, i + k));
			if (a != 0 && num % a == 0)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {

		// int num=430043;int k=2;
		int num = 240;
		int k = 2;

		System.out.println(new KBeautyNumber2269().divisorSubstrings(num, k));
	}

}
