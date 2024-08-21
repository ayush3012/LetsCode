package JavaCode;

import java.util.Stack;

/**Given two integer arrays pushed and popped each with distinct values, return true if this
 *  could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 *  */
public class ValidateStackSequence946 {

	public boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stk=new Stack<>();
		int pushInd=0;
		int popInd=0;
		while(popInd<popped.length)
		{
			while(pushInd<pushed.length && (stk.isEmpty() || stk.peek()!=popped[popInd]))
				stk.push(pushed[pushInd++]);
			if(stk.peek()==popped[popInd])
			{
				stk.pop();
				popInd++;
			}
			else 
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		//int[] pushed = {1,2,3,4,5};int[] popped = {4,5,3,2,1};

		int[] pushed = {1,2,3,4,5};int[] popped = {4,3,5,1,2};

		System.out.println(new ValidateStackSequence946().validateStackSequences(pushed, popped));


	}

}
