package DailyCheck.com.MyPack.Misc;

import java.util.HashMap;
import java.util.Map;

public class SumOfPairDivByK {

    static void code(int[] arr,int k)
    {
        int count=0;
        int[] freq=new int[k];
        for(int a:arr)
        {
            int rem=a%k;

            int compl=(k-rem)%k;
            count+=freq[compl];

            freq[rem]++;
        }
        System.out.println(count);//If need to print pair then two loops will be applied;
    }
    static void code2(int[] arr,int k)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        int count=0;
        for(int a:arr)
        {
            int rem=a%k;
            if(rem<0) rem+=k;
            int need=(k-a)%k;
            count+=hm.getOrDefault(need,0);
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        System.out.println(count);
    }
    public static void main(String[] args) {

        int[] arr={2,2,3,5,4,8};int k=4;

        code(arr,k);

        code(arr,k);
    }
}
