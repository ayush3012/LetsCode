package DailyCheck.com.MyPack.String;

public class PermutationInString567 {

    static boolean permuatationInOther(String s1,String s2)
    {
        int[] freq=new int[128];
        for(char c:s1.toCharArray()) freq[c]++;
        int required=s1.length();
        int left=0;
        for(int right=0;right<s2.length();right++)
        {
            char c=s2.charAt(right);
            if(freq[c]>0)
                required--;
            freq[c]--;
            while (right-left+1>s1.length())
            {
                freq[s2.charAt(left)]++;
                if(freq[s2.charAt(left)]>0)
                    required++;
                left++;
            }
            if(required==0)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";

        System.out.println(permuatationInOther(s1,s2));
    }
}
