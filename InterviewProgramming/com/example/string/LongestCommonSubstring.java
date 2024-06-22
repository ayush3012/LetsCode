package com.example.string;

public class LongestCommonSubstring {
	
	public static String CommonSubstring(String[] arr)
	{
		String res="";
		String s=arr[0];
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				String stem=s.substring(i,j);
				int k=1;
				for(k=1;k<arr.length;k++)
					if(!arr[k].contains(stem))
						break;
				if(k==arr.length && res.length()<stem.length())
					res=stem;
			}
		}
		return res;
	}

	public static String lcs(String[] strs)
	{
		if(strs==null || strs.length==0)
	          return "";
	         String pre=strs[0];
	         for(int i=1;i<strs.length;i++)
	         {
	             while(strs[i].indexOf(pre)==-1)
	                pre=pre.substring(0,pre.length()-1);
	         }
	       return pre;
	}
	public static void main(String[] args) {

		String arr[] = { "grace", "graceful",
                "disgraceful","gracefully" };
		String s=CommonSubstring(arr);
		System.out.println(s);
		System.out.println();
		System.out.println(lcs(arr));
	}

}
