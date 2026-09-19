package DailyCheck_WarmUP.Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber179 {

    public static String largestNumber(int[] nums)
    {
        Integer[] arr= Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr,(a,b)->{
            String s=a+""+b;
            String t=b+""+a;
            return t.compareTo(s);
        });
        String res="";
        for(int a:arr)
            res+=a;
        if(arr[0]==0)
            return "0";
        return res;
    }

    static String largestNumberWithStream(int[] nums)
    {
        String res=Arrays.stream(nums).boxed().sorted((a,b)->{
            String s=a+""+b;
            String t=b+""+a;
            return t.compareTo(s);
        }).map(String::valueOf).collect(Collectors.joining(""));

        return res.startsWith("0")?"0":res;
    }
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        //Output: "9534330"

        System.out.println(largestNumber(nums)+" "+largestNumberWithStream(nums));
    }
}
