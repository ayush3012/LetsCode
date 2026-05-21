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
    public static void main(String[] args)
    {
        String s="123";

        List<String> res=new ArrayList<>();

        decode(s,0,"",res);

        res.forEach(i-> System.out.println(i));
    }
}
