package JavaCode;

public class HomogenousSubstring {
	
	public static int countHomogenous(String s)
	{
		char ch=s.charAt(0);
		int count=1;
		int res=1;
		for(int i=1;i<s.length();i++)
		{
			if(ch==s.charAt(i))
				count++;
			else
			{
				count=1;
				ch=s.charAt(i);
			}
			res+=count;
		}
		return res;
	}

	public static void main(String[] args) {
		
		String s="aaaaa";
		
		System.out.println(countHomogenous(s));
	}

}
