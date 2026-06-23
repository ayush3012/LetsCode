package DailyCheck.com.MyPack.Misc;

import java.util.ArrayList;
import java.util.List;

public class TopNPrime {

    static boolean isPrime(int a)
    {
        if(a<=1) return false;
        for(int i=2;i*i<=a;i++)
            if(a%i==0) return false;
        return true;
    }
    static void code()
    {
        List<Integer> al=new ArrayList<>();
        int a=2;
        int count=0;
        while(count<10)
        {
            if(isPrime(a))
            {
                al.add(a);
                count++;
            }
            a++;
        }
        al.forEach(System.out::println);
    }
    public static void main(String[] args) {

        code();
    }
}
