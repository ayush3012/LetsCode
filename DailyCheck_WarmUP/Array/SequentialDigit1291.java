package DailyCheck_WarmUP.Array;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigit1291 {

    static void sequentialDigit(int low,int high)
    {
        List<Integer> res=new ArrayList<>();
        for(int i=String.valueOf(low).length();i<=String.valueOf(high).length();i++)
        {
            for(int j=1;j<10-i;j++)
            {
                int num=0;
                int digit=j;
                for(int k=0;k<i;k++)
                {
                    num=num*10+digit;
                    digit++;
                }
                if(num>=low && num<=high)
                     res.add(num);
            }
        }
        System.out.println(res);
    }

    static void sequentialDigit_slidingWindow(int low,int high)
    {
        List<Integer> res=new ArrayList<>();
        String s="123456789";
        for(int i=(""+low).length();i<=(""+high).length();i++)
        {
            int left=0;
            while(left+i-1<s.length())
            {
                String sub=s.substring(left,left+i);
                int x=Integer.parseInt(sub);
                if(x>=low && x<=high)
                    res.add(x);
                left++;
            }
        }
        res.forEach(i-> System.out.println(i));
    }
    public static void main(String[] args) {
        int low=100,high=300;

        sequentialDigit(low,high);
    }
}
