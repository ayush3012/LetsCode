package com.mypack.String;

public class Permutation {
	
	public static void permute(String pre,String word)
	{
		if(word.length()==0)
			System.out.println(pre);
		else
		{
			for(int i=0;i<word.length();i++)
				permute(pre+word.charAt(i), word.substring(0,i)+word.substring(i+1));
		}
	}

	public static void permute(String s)
	{
		permute("",s);
	}
	
	public static void main(String[] args) {
		
		String str="abc";
		
		//permute(str);
		
		//if we want substring permutation also
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<=str.length();j++)
				permute(str.substring(i,j));
				
		}
	}

}
