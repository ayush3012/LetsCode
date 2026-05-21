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
    public static void main(String[] args)
    {
        String s="adobecodebanc";
        String x="abc";

        minWindow(s,x);
    }
}
