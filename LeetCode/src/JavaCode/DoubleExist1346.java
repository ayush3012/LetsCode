package JavaCode;

import java.util.ArrayList;
import java.util.List;

/*Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]*/
public class DoubleExist1346 {
	
public boolean checkIfExist(int[] arr) {
        
	   List<Integer> al=new ArrayList<>();
	   for(int a:arr)
	   {
		   double h=a/2.0;
		   if(al.contains(2*a) || (h%1==0 && al.contains(a/2)))
			   return true;
		   al.add(a);
	   }
	   return false;
	   
    }

	public static void main(String[] args) {
		
		//int[] arr= {10,2,5,3};     //true
		
		//int[] arr= {3,1,7,11};     //false
		
		//int[] arr= {7,1,14,11};   //true
		
		int[] arr= {-2,0,10,-19,4,6,-8}; //false
		
		System.out.println(new DoubleExist1346().checkIfExist(arr));

	}

}
