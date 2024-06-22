package JavaCode;

//Write a function to find the longest common prefix string amongst an array of strings.

//If there is no common prefix, return an empty string ""
public class LongestCommonPrefix {

	public static String lcp(String[] strs)
	{
		if(strs==null || strs.length==0)
	          return "";
	         String pre=strs[0];
	         for(int i=1;i<strs.length;i++)
	         {
	             while(strs[i].indexOf(pre)!=0)
	                pre=pre.substring(0,pre.length()-1);
	         }
	       return pre;
	}

	public static void main(String[] args) {

		//String[] strs= {"reflower","flow","flight"};
		String[] strs={"flower","flow","flight"};

		System.out.println(lcp(strs));
	}

}
