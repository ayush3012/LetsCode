package DailyCheck.com.MyPack.Array;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet853 {

    static void carFleet(int[] position,int[] speed,int target)
    {
        int n= position.length;
        int[][] cars=new int[n][2];
        for(int i=0;i<n;i++)
        {
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars,(a,b)->b[0]-a[0]);
        Stack<Double> stk=new Stack<>();

        for(int[] car:cars)
        {
            double time=(double) (target-car[0])/car[1];

            if(stk.isEmpty() || time>stk.peek())
                stk.push(time);
        }
        System.out.println(stk.size());
    }
    public static void main(String[] args) {

        int target = 12;int[] position = {10,8,0,5,3};int[] speed = {2,4,1,1,3};

        carFleet(position,speed,target);
    }
}
