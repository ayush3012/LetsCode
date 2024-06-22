package JavaCode;

/*
 * Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       
The above arrows point to positions where the corresponding bits are different.
*/
public class HammingDistance461 {
	
	 public int hammingDistance(int x, int y) {
		 
		 int xor=x^y;
		 int count=0;
		 while(xor>0)
		 {
			 xor=xor & (xor-1);
			 count++;
		 }
		 return count; 
	    }

	public static void main(String[] args) {
		
		System.out.println(new HammingDistance461().hammingDistance(1,4));

	}

}
