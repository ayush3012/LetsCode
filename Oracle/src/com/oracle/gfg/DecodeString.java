package com.oracle.gfg;

public class DecodeString {
	
	public static int decode(String s)
	{
		if(s.length()==0 || s.charAt(0)=='0') return 0;
		if(s.length()==1) return 1;
		int c=1;
		for(int i=1;i<s.length();i++)
		{
			int d=s.charAt(i)-'0';
			int dd=(s.charAt(i-1)-'0')*10+d;
			int c1=0;int c2=0;
			if(d>0) c1++;
			if(dd>=10 && dd<=26) c2++;
			c+=c1+c2;
		}
		return c;
	}

	public static void main(String[] args) {
		
		String s="123";
		
		System.out.println(decode(s));
	}

}
