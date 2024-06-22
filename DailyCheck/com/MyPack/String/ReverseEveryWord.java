package com.mypack.String;

public class ReverseEveryWord {
	
	public static void Reverse(String str)
	{
		String[] arr=str.split(" ");
		
		String res="";
		
		for(int i=arr.length-1;i>=0;i--)
			{
			  res+=arr[i];
			  res+=" ";
			}
		System.out.println(res);
	}

	public static void main(String[] args) {
		
		
		String str="i am ayush karna";
		
		Reverse(str);

	}

}
