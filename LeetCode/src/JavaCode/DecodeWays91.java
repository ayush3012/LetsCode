package JavaCode;

/*Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).*/
public class DecodeWays91 {
	
	public int numDecodings(String s) {
		
		if(s==null || s.length()==0 || s.charAt(0)=='0')
			return 0;
		int prev1=1;
		int prev2=1;
		for(int i=1;i<s.length();i++)
		{
			int curr=0;
			int od=s.charAt(i)-'0';
			int td=(s.charAt(i-1)-'0')*10+od;
			if(od>=1 && od<=9)
				curr+=prev1;
			if(td>=10 && td<=26)
				curr+=prev2;
			prev2=prev1;
			prev1=curr;
		}
		return prev1;
	}

	public static void main(String[] args) {
		
		//String s="12";
		//String s="226";
		String s="06";
		
		System.out.println(new DecodeWays91().numDecodings(s));

	}

}
