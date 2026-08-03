package DailyCheck.com.MyPack.String;

import java.util.*;

public class WordLadder127 {

    static int ladderLength(String beginWord,String endWord,List<String> wordList)
    {
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);

        Set<String> dict=new HashSet<>(wordList);

        if(!dict.contains(endWord))
            return 0;

        int level=1;

        while (!q.isEmpty())
        {
            int n=q.size();
            while (n-->0)
            {
                String word=q.poll();
                if(word.equals(endWord))
                    return level;
                char[] ch=word.toCharArray();
                for (int i=0;i< ch.length;i++)
                {
                    char orig=ch[i];
                    for(char c='a';c<='z';c++)
                    {
                        if(c==orig) continue;

                        ch[i]=c;

                        String nextWord=new String(ch);
                        if(dict.contains(nextWord))
                        {
                            q.add(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                    ch[i]=orig;
                }
            }
            level++;
        }
       return 0;
    }
    public static void main(String[] args) {
//        String beginWord = "hit";String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hot";String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dog","dot");

        System.out.println(ladderLength(beginWord,endWord,wordList));

    }
}
