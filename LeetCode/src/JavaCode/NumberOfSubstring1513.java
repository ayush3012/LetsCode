package JavaCode;
/*Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.*/
public class NumberOfSubstring1513 {
	
	public int numSub(String s) {

		long count=0;
		long len=0;
		long M = 1000000007;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='1')
				len+=++count;
			else
				count=0;
		return (int) (len%M);
	}

	public static void main(String[] args) {
		
		//String s = "0110111";
		
		//String s = "101";
		
		String s = "111111";
		
		System.out.println(new NumberOfSubstring1513().numSub(s));

	}

}
