package LeetCode.src.JavaCode;

import java.util.ArrayList;
import java.util.List;

public class AllAnagram438 {

    // idea is same as finding permutation od p in s and store starting index
    static void allAnagram(String s,String p)
    {
        List<Integer> res=new ArrayList<>();
        int[] freq=new int[128];
        for(char c:p.toCharArray()) freq[c]++;
        int left=0,required=p.length();
        for(int right=0;right<s.length();right++)
        {
            char c=s.charAt(right);
            if(freq[c]>0)
                required--;
            freq[c]--;
            while (right-left+1>p.length())
            {
                char x=s.charAt(left);
                if(++freq[x]>0)
                    required++;
                left++;
            }
            if(required==0) res.add(left);
        }
        res.forEach(System.out::println);
    }
    public static void main(String[] args) {
       String s = "cbaebabacd";String p = "abc";

       allAnagram(s,p);
    }
}
