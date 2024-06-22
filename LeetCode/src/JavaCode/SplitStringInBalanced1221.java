package JavaCode;

public class SplitStringInBalanced1221 {
	
public int balancedStringSplit(String s) {
        
	int count=0;
	for(int i=0;i<s.length();i++)
	{
		String str="";
		for(int j=i+1;j<s.length()+1;j++)
			{
			  str=s.substring(i,j);
			  if(str.length()>1 && isBalanced(str) )
					{
				       count++;
				       i=j-1;
				       break;
					}
			}
	}
	return count;
    }
public boolean isBalanced(String s)
{
	int countR=0;
	int countL=0;
	for(int i=0;i<s.length();i++)
	{
		if(s.charAt(i)=='R')
			countR++;
		else
			countL++;
	}
	return countL==countR;
}

public int balancedStringSplit_leetCode(String s) {
    int count = 0;
    int chr = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'R') chr++; else chr--;
        if (chr == 0) count++;
    }
    return count;
}

	public static void main(String[] args) {
		
		System.out.println(new SplitStringInBalanced1221().balancedStringSplit("RLRRLLRLRL"));
		
		System.out.println(new SplitStringInBalanced1221().balancedStringSplit("RLRRRLLRLL"));
		
		System.out.println(new SplitStringInBalanced1221().balancedStringSplit("LLLLRRRR"));
		
		System.out.println(new SplitStringInBalanced1221().balancedStringSplit_leetCode("LLLLRRRR"));

	}

}
