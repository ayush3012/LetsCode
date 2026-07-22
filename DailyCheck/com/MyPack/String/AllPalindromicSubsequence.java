package DailyCheck.com.MyPack.String;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromicSubsequence {

    static boolean isPalindrome(String s)
    {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    static void generateAllPalindromicSubsequence(String s, int ind, StringBuilder curr, List<String> res)
    {
        if(s.length()==ind)
        {
            if(curr.length()>0 && isPalindrome(curr.toString()))
                res.add(curr.toString());
            return;
        }
        curr.append(s.charAt(ind));
        generateAllPalindromicSubsequence(s,ind+1,curr,res);
        curr.deleteCharAt(curr.length()-1);
        generateAllPalindromicSubsequence(s,ind+1,curr,res);
    }

    static int countPalindromicSubsequence(String s) // for leetcode, if we want only count
    {
        int n = s.length();
        long MOD = 1000000007L;

        long[][] dp = new long[n][n];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    int low = i + 1;
                    int high = j - 1;

                    while (low <= high && s.charAt(low) != s.charAt(i))
                        low++;

                    while (low <= high && s.charAt(high) != s.charAt(i))
                        high--;

                    if (low > high) {
                        // No same character inside
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (low == high) {
                        // One same character inside
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        // More than one same character inside
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                    }

                } else {
                    dp[i][j] = dp[i + 1][j]
                            + dp[i][j - 1]
                            - dp[i + 1][j - 1];
                }

                dp[i][j] %= MOD;
                if (dp[i][j] < 0)
                    dp[i][j] += MOD;
            }
        }

        return (int) dp[0][n - 1];
    }
    public static void main(String[] args) {
        String s="aba";

        List<String> res=new ArrayList<>(); // replace this with set to get unique result only

        generateAllPalindromicSubsequence(s,0,new StringBuilder(),res);

        System.out.println(res);

        System.out.println(countPalindromicSubsequence(s));
    }
}
