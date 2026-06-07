package LeetCode.src.JavaCode;

/**
 * You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
 * Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
 * Example 1:
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
 * */
public class SmallestNumberGreaterThanTarget744 {

    public char nextGreatestLetter(char[] letters, char target) {

        char res='0';
        int t=target;
        int min=0;
        for(int i=0;i< letters.length;i++)
        {
            int c=letters[i];
            if(min<c-t)
            {
                res=(char)c;
                break;
            }
        }
        return res=='0'?letters[0]:res;
    }
    public static void main(String[] args) {

        char[] letters = {'x','x','y','y'}; char target = 'z';

        System.out.println(new SmallestNumberGreaterThanTarget744().nextGreatestLetter(letters,target));
    }
}
