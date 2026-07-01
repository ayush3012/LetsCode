package DailyCheck.com.MyPack.String;

public class LongestRepeatCharRplc424 {

    static void characterReplacement(String s,int k)
    {
        int[] freq=new int[128];
        int left=0;
        int maxFreq=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            freq[c]++;
            maxFreq=Math.max(maxFreq,freq[c]);
            while ((i-left+1)-maxFreq>k)
                freq[s.charAt(left++)]--;
            max=Math.max(max,i-left+1);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        String s = "ABAB";int k = 2;

        characterReplacement(s,k);
    }
}
