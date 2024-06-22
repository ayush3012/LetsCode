package com.mypack.String;

public class LongestSubString {
	
	public static void longestSubstring(String[] str)
	{
		String res="";
		for(int i=0;i<str[0].length();i++)
		{
			for(int j=i+1;j<=str[0].length();j++)
			{
				String substr=str[0].substring(i,j);
				for(int k=1;k<str.length;k++)
				{	if(!str[k].contains(substr))
						break;
				    if(res.length()<substr.length())
					  res=substr;
				}
			}
		}
		System.out.println("Longest substring "+res);
	}

	public static void main(String[] args) 
	{
	
		String arr[] = { "grace", "graceful","disgraceful","gracefully" };
		
		longestSubstring(arr);
		
	}

}
