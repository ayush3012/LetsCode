package DailyCheck_WarmUP.TwoDArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPoint973 {

    static int distance(int[] arr)
    {
        return arr[0]*arr[0]+arr[1]*arr[1];
    }
    static void Kclosest(int[][] points,int k)
    {
        int[][] res=new int[k][2];
        int i=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->distance(a)-distance(b));
        Collections.addAll(pq,points);
        while (k-->0)
            res[i++]=pq.poll();
        for(int[] arr:res)
            System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};int k = 2;

        Kclosest(points,k);
    }
}
