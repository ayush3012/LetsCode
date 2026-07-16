package DailyCheck.com.MyPack.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler621 {

    static int leastInterval(char[] tasks,int n)
    {
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->b-a);
        Map<Character,Integer> hm=new HashMap<>();
        for(char c:tasks) hm.put(c,hm.getOrDefault(c,0)+1);
        int maxf=0,numMaxf=0;
        for(char c:hm.keySet())
        {
            pq.add(c);
            maxf=Math.max(maxf,hm.get(c));
        }
        for(char c:pq)
        {
            if(hm.get(c)==maxf)
                numMaxf++;
        }
        return Math.max(tasks.length,(maxf-1)*(n+1)+numMaxf);
        /*
        * interval between two same:maxf-1
        * each row have n+1 element because (n+1)th elements are same
        * last row contains all tasks having frequency==maxFreq
        * */
    }

    public static void main(String[] args) {
        char[] tasks={'A','A','A','B','B','B'};
        int n=2;

        System.out.println(leastInterval(tasks,n));
    }
}
