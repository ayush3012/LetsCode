package DailyCheck.com.MyPack.String;

import java.util.Stack;

public class SmallestSubsequenceLexico1081 {

    static void smallestSubsequence(String s)
    {
        int[] last=new int[26];
        boolean[] visited=new boolean[26];
        Stack<Character> stk=new Stack<>();

        for (int i=0;i<s.length();i++) last[s.charAt(i)-'a']=i;

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            if(visited[c-'a'])
                continue;
            while (!stk.isEmpty() && stk.peek()>c && last[stk.peek()-'a']>i)
                visited[stk.pop()-'a']=false;
            stk.push(c);
            visited[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stk)
            sb.append(c);
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String s="cbacdcbc";

        smallestSubsequence(s);
    }
}
