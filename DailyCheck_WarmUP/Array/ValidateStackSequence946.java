package DailyCheck_WarmUP.Array;

import java.util.Stack;

public class ValidateStackSequence946 {

    static boolean validateSequence(int[] pushed,int[] popped)
    {
        Stack<Integer> stk=new Stack<>();
        int pushInd=0;
        int popInd=0;
        while(pushInd<pushed.length)
        {
            stk.push(pushed[pushInd++]);
            while (!stk.isEmpty() && stk.peek()==popped[popInd])
            {
                stk.pop();
                popInd++;
            }
        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};int[] popped = {4,5,3,2,1};

        //int[] pushed = {1,2,3,4,5};int[] popped = {4,3,5,1,2};

        System.out.println(validateSequence(pushed,popped));
    }
}
