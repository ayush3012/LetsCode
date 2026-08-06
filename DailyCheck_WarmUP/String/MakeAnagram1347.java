package DailyCheck_WarmUP.String;

public class MakeAnagram1347 {

    static void solve(String s,String t)
    {
        int[] arr=new int[26];

        for(char c:s.toCharArray()) arr[c-'a']++;
        for(char c:t.toCharArray()) arr[c-'a']--;
        int sum=0;
        for(int a:arr)  // net frequency difference solve the problem, +ve means t has that extra character
        {
            if(a>0)
                sum+=a;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        String s="aba";String t="bab";

        solve(s,t);
    }
}
