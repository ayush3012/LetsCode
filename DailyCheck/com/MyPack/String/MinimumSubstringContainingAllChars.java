package DailyCheck.com.MyPack.String;

public class MinimumSubstringContainingAllChars {

    static void minWindow(String s,String x)
    {
        int[] sarr=new int[256];
        int[] xarr=new int[256];

        for(int i=0;i<x.length();i++)
            xarr[x.charAt(i)]++;

        int st=0,start=0,min=Integer.MAX_VALUE,count=0;

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            sarr[c]++;

            if(xarr[c]>0 && sarr[c]<=xarr[c])
                count++;

            if(count==x.length())
            {
                char sc;
                while (sarr[sc=s.charAt(st)] > xarr[sc] || xarr[sc]==0)
                {
                    if(sarr[sc]>xarr[sc])
                        sarr[sc]--;
                    st++;
                }
                if(min>i-st+1)
                {
                    min=i-st+1;
                    start=st;
                }
            }
        }
        System.out.println(s.substring(start,start+min));

    }

    static String minWindow_method2(String s,String t)
    {
        if(s.length()<t.length()) return "";

        int[] freq=new int[128];

        for(char c:t.toCharArray()) freq[c]++;

        int left=0,start=0,minLen=Integer.MAX_VALUE;
        int required=t.length();

        for(int right=0;right<s.length();right++)
        {
            if(freq[s.charAt(right)]-- >0)
                required--;
            while (required==0)
            {
                if(right-left+1<minLen)
                {
                    minLen=right-left+1;
                    start=left;
                }
                if(++freq[s.charAt(left++)]>0)
                    required++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
    public static void main(String[] args)
    {
        String s="adobecodebanc";
        String x="abc";

        minWindow(s,x);
        System.out.println();

        System.out.println(minWindow_method2(s,x));
    }
}
