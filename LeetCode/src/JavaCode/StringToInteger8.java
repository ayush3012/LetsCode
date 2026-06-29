package LeetCode.src.JavaCode;

public class StringToInteger8 {

    public static int myAtoi(String s) {

        int i=0,sign =1;
        long num=0;
        s=s.trim();
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-'))
            sign=s.charAt(i++)=='-'?-1:1;
        while (i<s.length() && Character.isDigit(s.charAt(i)))
        {
            num=num*10+(s.charAt(i)-'0');
            if(sign*num>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign*num<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign*num);
    }
    public static void main(String[] args) {

        System.out.println(myAtoi(" -042"));
    }
}
