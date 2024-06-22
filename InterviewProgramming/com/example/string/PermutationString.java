package com.example.string;

public class PermutationString {

	public static void permutation(String str)
	{
		permutation("",str);
	}
	public static void permutation(String pre,String word)
	{
		if(word.length()==0)
			System.out.println(pre+word);
		else
		for(int i=0;i<word.length();i++)
			permutation(pre+word.charAt(i),word.substring(0, i)+word.substring(i+1));
	}
	public static void main(String[] args) {
		String str="abc";
		permutation(str);
		
		//for(int i=0;i<str.length();i++)
    	//	for(int j=i;j<str.length();j++)
    		//	permutation("",str.substring(i,j+1));
		
	}

}
