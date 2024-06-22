package JavaCode;
/*Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.*/
public class LargestStringBetweenCharacter1624 {
	
	public int maxLengthBetweenEqualCharacters(String s) {
		
		int res=-1;
		for(int i=0;i<s.length();i++)
		{
			if(s.indexOf(s.charAt(i))!=s.lastIndexOf(s.charAt(i)))
			{
				int max=s.lastIndexOf(s.charAt(i))-s.indexOf(s.charAt(i))-1;
				res=Math.max(max,res);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		
		//String s = "aa";
		//String s = "abca";
		String s = "cbzxy";
		
		System.out.println(new LargestStringBetweenCharacter1624().maxLengthBetweenEqualCharacters(s));

	}

}
