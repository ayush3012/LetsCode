package DailyCheck.com.MyPack.Array;

import java.util.Stack;

public class AesteroidCollison735 {

    static void aesteroidCollison(int[] asteroid)
    {
        Stack<Integer> stack=new Stack<>();
        for(int a:asteroid)
        {
            if(a>0) stack.push(a);
            else {
                while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(a))
                    stack.pop();
                if(stack.isEmpty() || stack.peek()<0)
                    stack.push(a);
                else if (stack.peek()==Math.abs(a))
                    stack.pop();
            }
        }
        stack.forEach(i-> System.out.print(i+" "));
    }
    public static void main(String[] args) {

        //int[] asteroids = {5,10,-5};
        //int[] asteroids = {8,-8};
        int[] asteroids = {10,2,-5};

        aesteroidCollison(asteroids);
    }
}
