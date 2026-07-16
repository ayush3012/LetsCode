package DailyCheck.com.MyPack.Array;

import java.util.PriorityQueue;

public class EatenApple1705 {

    static int eatenApple(int[] apples,int[] days)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int day=0,ans=0;
        while (day< days.length || !pq.isEmpty())
        {
            if(day<days.length && apples[day]>0)
                pq.add(new int[]{day+days[day],apples[day]});
            while (!pq.isEmpty() && pq.peek()[0]<=day)
                pq.poll();
            if(!pq.isEmpty())
            {
                int[] curr=pq.poll();
                curr[1]--;
                ans++;
                if(curr[1]>0)
                    pq.add(curr);
            }
            day++;
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] apples = {1,2,3,5,2};int[] days = {3,2,1,4,2};

        System.out.println(eatenApple(apples,days));
    }
}
