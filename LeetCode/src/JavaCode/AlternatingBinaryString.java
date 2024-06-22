package JavaCode;

//Minimum number of replacement of 0->1 and 1->0 to get binary string in alternate position
public class AlternatingBinaryString {
	
	public static int AlternateBinaryString(String s)
	{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(i%2==0 && s.charAt(i)=='0')
				count++;
			if(i%2==1 && s.charAt(i)=='1')
				count++;
		}
		return Math.min(count,s.length()-count);
	}

	public static void main(String[] args) {
		
		String s="1100000";
		System.out.println(AlternateBinaryString(s));
	}

}
