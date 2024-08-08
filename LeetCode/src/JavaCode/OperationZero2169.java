package JavaCode;

/**You are given two non-negative integers num1 and num2.

In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.

For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4. However,
 if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
Return the number of operations required to make either num1 = 0 or num2 = 0.
*/
public class OperationZero2169 {
	
	public int countOperations(int num1, int num2) {

	       int count=0;
	        while(num1!=0 && num2!=0)
	        {
	            if(num1>=num2)
	            {
	                count+=num1/num2;
	                num1%=num2;
	            }
	            else
	             {
	                count+=num2/num1;
	                num2%=num1;
	             }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		
		int num1=2;int num2=3;
		
		System.out.print(new OperationZero2169().countOperations(num1, num2));

	}

}
