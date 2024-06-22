package JavaCode;

/*The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its 
 * binary representation.For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.*/
public class BitComplement476 {
	
	public int findComplement(int num) {
        int mask=(Integer.highestOneBit(num)<<1)-1;
        return num^mask;
    }
	

	public static void main(String[] args) {
		
		System.out.println(new BitComplement476().findComplement(10)); 

	}

}
