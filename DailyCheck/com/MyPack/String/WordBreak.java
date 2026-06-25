package DailyCheck.com.MyPack.String;

public class WordBreak {

    static boolean findWord(String s,String[] dict)
    {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length()+1;i++)
        {
            for(String w:dict)
            {
                int st=i-w.length();
                if(st>=0 && dp[st] && s.substring(st,st+w.length()).equals(w))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s="ilike";
        String[] dict={"i","like","gfg"};

        System.out.println(findWord(s,dict));
    }
}
