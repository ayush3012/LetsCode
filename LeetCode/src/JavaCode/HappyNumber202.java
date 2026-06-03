package LeetCode.src.JavaCode;

import java.util.HashSet;
import java.util.Set;

/*
* Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */
public class HappyNumber202 {

    static void HappyNumber(int a)
    {
        Set<Integer> seen=new HashSet<>();
        while (a!=1 && !seen.contains(a))
        {
            seen.add(a);
            int sum=0;
            while (a>0)
            {
                sum+=(a%10)*(a%10);
                a=a/10;
            }
            a=sum;
        }
        System.out.println(a==1);
    }
    public static void main(String[] args) {
        int a=19;

        int a2=2;

        HappyNumber(a);

        HappyNumber(a2);
    }
}
