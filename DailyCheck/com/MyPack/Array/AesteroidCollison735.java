package DailyCheck.com.MyPack.Array;

import java.util.Stack;

public class AesteroidCollison735 {

    static void aesteroidCollison(int[] asteroid)
    {
        Stack<Integer> stk=new Stack();
        for(int a:asteroid)
        {
            if(a>0) stk.push(a);
            else {
                while (!stk.isEmpty() && stk.peek()>0 && a<0 && stk.peek()<=Math.abs(a))
                    stk.pop();
                if(stk.isEmpty() && stk.peek()<0)
                    stk.push(a);
                else if(stk.peek()==Math.abs(a))
                    stk.pop();
            }
        }
        stk.forEach(i-> System.out.print(i+" "));
    }
    public static void main(String[] args) {

        //int[] asteroids = {5,10,-5};
        //int[] asteroids = {8,-8};
        int[] asteroids = {10,2,-5};

        aesteroidCollison(asteroids);
    }
}
