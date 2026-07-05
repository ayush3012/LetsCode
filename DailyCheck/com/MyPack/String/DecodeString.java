package DailyCheck.com.MyPack.String;

import java.util.ArrayList;
import java.util.List;

//decode string. str=123->abc,lc,aw...how many possible
public class DecodeString {

    static void decode(String s, int ind,String curr, List<String> res)
    {
        if(ind==s.length())
        {
            res.add(curr);
            return ;
        }

        int onedigit=s.charAt(ind)-'0';
        if(onedigit>=1 && onedigit<=9)
        {
            char c=(char)('a'+onedigit-1);
            decode(s,ind+1,curr+c,res);
        }
        if(ind+1<s.length())
        {
            int twodigit=Integer.parseInt(s.substring(ind,ind+2));
            if(twodigit>=10 && twodigit<=26)
            {
                char c=(char)('a'+twodigit-1);
                decode(s,ind+2,curr+c,res);
            }
        }

    }

    static void countWays(String s)
    {
        if(s==null || s.isEmpty() || s.charAt(0)=='0')
            return;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=s.length();i++)
        {
            int one=s.charAt(i-1)-'0';
            int two=(s.charAt(i-2)-'0')*10+one;
            if(one>0) dp[i]+=dp[i-1];
            if(two>=10 && two<=26) dp[i]+=dp[i-2];
        }
        System.out.println(dp[s.length()]);
    }
    public static void main(String[] args)
    {
        String s="123";

        List<String> res=new ArrayList<>();

        decode(s,0,"",res);

        res.forEach(System.out::println);


        countWays(s);
    }
}
