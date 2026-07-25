package DailyCheck_WarmUP.Array;

import java.util.HashMap;
import java.util.Map;

public class FruitsBasket904 {

    static int fruits(int[] fruits)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        int left=0,max=0;
        for(int i=0;i<fruits.length;i++)
        {
            hm.put(fruits[i],hm.getOrDefault(fruits[i],0)+1);
            while (hm.size()>2)
            {
                hm.put(fruits[left],hm.get(fruits[left])-1);
                if(hm.get(fruits[left])==0)
                    hm.remove(fruits[left]);
                left++;
            }
            max=Math.max(max,i-left+1);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2};

        System.out.println(fruits(arr));
    }
}
