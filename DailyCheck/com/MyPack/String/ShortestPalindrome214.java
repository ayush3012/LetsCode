package DailyCheck.com.MyPack.String;

import java.util.stream.IntStream;

//This is hard problem of leet code passed 121/126
public class ShortestPalindrome214 {
    static boolean isPal(String s)
    {
        return IntStream.range(0,s.length()).allMatch(i->s.charAt(i)==s.charAt(s.length()-i-1));
    }

    public  static void code(String s) {

        String temp=s;
        while(!isPal(temp))
            temp=temp.substring(0,temp.length()-1);
        String a=new StringBuilder(s.substring(temp.length(),s.length())).reverse().toString();
        s=a+s;
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {

        String s = "aacecaaa";

        code(s);
    }
}
