package DailyCheck.com.MyPack.String;

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

    }
}
