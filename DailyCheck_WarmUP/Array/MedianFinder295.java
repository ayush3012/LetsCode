package DailyCheck_WarmUP.Array;

import java.util.PriorityQueue;

public class MedianFinder295 {

     PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

     MedianFinder295()
     {
         left=new PriorityQueue<>((a,b)->b-a);
         right=new PriorityQueue<>();
     }
     public void add(int num)
     {
         left.add(num);
         right.add(left.poll());
         if(right.size()>left.size())
             left.add(right.poll());
     }

     public double findMedian()
     {
         if((left.size()+right.size())%2==0)
             return left.peek()+right.peek()/2.0;
         return 1.0*left.peek();
     }
    public static void main(String[] args) {

         MedianFinder295 finder=new MedianFinder295();

         finder.add(1);
         finder.add(2);
         finder.add(3);

        System.out.println(finder.findMedian());
    }
}
