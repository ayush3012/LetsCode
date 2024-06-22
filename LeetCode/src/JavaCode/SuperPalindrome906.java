package JavaCode;

/*Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, return the number of super-palindromes integers in 
the inclusive range [left, right].
Input: left = "4", right = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
*/
public class SuperPalindrome906 {

	public int superpalindromesInRange(String left, String right) {
		
		int ans = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;
        for (int i = 1; i < 19684; i++) {
            String num = Integer.toString(i, 3);
            if (isPalindrome(num)) {
                long square = Long.parseLong(num) * Long.parseLong(num);
                if (square > Long.parseLong(right)) return ans;
                if (square >= Long.parseLong(left) && isPalindrome(Long.toString(square))) ans++;
            }
        }
        return ans;
	}

	public boolean isPalindrome(String s) {
		return s!=null && s.equals(new StringBuffer(s).reverse().toString());
	}

	public static void main(String[] args) {

		//String left = "4";String right = "1000";
		String left = "1";String right = "5";

		System.out.println(new SuperPalindrome906().superpalindromesInRange(left, right));

	}

}
