package JavaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LongestPalindromicSubstring {

	 public static String longestPalindrome(String s) {//This will pass all test case but time limit will exceed
	        int max=0;
	        String res="";
	        TreeMap<Character,List<Integer>> tm=new TreeMap<>();
	        for(int j=0;j<s.length();j++)
	        {
	        	char ch=s.charAt(j);
	        	List<Integer> al=new ArrayList<>();
	        	if(tm.containsKey(ch))
	        	    al.addAll(tm.get(ch));
	        	al.add(j);
	        	for(int i:al)
	        	{
	        		if(isPal(s.substring(i,j+1)))
	        		{
	        			if(max<j-i+1)
	        			{
	        				max=j-i+1;
	        				res=s.substring(i,j+1);
	        			}
	        		}
	        	}
	        	tm.put(ch, al);
	        }
	        return res;
	    }
	    public static boolean isPal(String s)
	    {
	        return s.equals(new StringBuffer(s).reverse().toString());
	    }
	public static void main(String[] args)
	{
		System.out.println(longestPalindrome("abab"));
	}

}
