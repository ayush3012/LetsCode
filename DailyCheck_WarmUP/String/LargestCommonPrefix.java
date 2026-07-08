package DailyCheck_WarmUP.String;

import java.util.Arrays;

public class LargestCommonPrefix {
	
	public static void Prefix(String[] str)
	{
		String s=str[0];
		for(int i=1;i<str.length;i++)
		{
			while(str[i].indexOf(s)!=0)          //prefix shrinking will take O(m) and in worst case while
				s=s.substring(0,s.length()-1);  //would take O(m^2) TC
		}
		System.out.println("Largest prefix "+s);
	}

	/*
	Arrays.sort -> uses dual pivotal quick sort which sorts in lexicographical order.
	if input string array is -> {"geeksforgeeks", "geeks", "geek", "geezer","leetcode"}
	sorted output is -> [ "geek", "geeks", "geeksforgeeks", "geezer", "leetcode" ]

	TC is O(nlogn)

	Below is more optimized approach.
	* */
	public static void Prefix_method2(String[] str)
	{
		Arrays.sort(str);
		String f=str[0];
		String l=str[str.length-1];
		int i=0;
		while(i<f.length() && f.charAt(i)==l.charAt(i))
			i++;

		System.out.println("Longest common prefix is : "+f.substring(0,i));

	}

	public static void main(String[] args) {
		
		String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
		
		Prefix(input);

		Prefix_method2(input);

	}

}
