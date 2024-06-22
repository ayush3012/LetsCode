package JavaCode;

import java.math.BigInteger;

public class AddBinary {
	
	private static String addBinaryInt(String a,String b)
	{
		int x=Integer.parseInt(a,2);
		int y=Integer.parseInt(b,2);
		return Integer.toBinaryString(x+y);
	}
	private static String addBinaryBigInt(String a,String b)
	{
		BigInteger x=new BigInteger(a,2);
		BigInteger y=new BigInteger(b,2);
		
		return x.add(y).toString(2);
	}

	public static void main(String[] args) {
		
		String a="100";
		String b="100";
		System.out.println(addBinaryBigInt(a, b));
		System.out.println(addBinaryInt(a, b));

	}

}
