package JavaCode;

/*Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.*/
public class LongestCommonSubsequence {
	
	 public static String longestCommonSubsequence(String text1, String text2) {

		 char[] first=text1.toCharArray();
         char[] sec=text2.toCharArray();
         int m=first.length;
         int n=sec.length;
         int[][] arr=new int[m+1][n+1];
         for(int i=0;i<m+1;i++)
           arr[i][0]=0;
         for(int i=0;i<n+1;i++)
           arr[0][i]=0;
          for(int i=1;i<m+1;i++)
          {
              for(int j=1;j<n+1;j++)
              {
                  if(first[i-1]==sec[j-1])
                    arr[i][j]=arr[i-1][j-1]+1;
                   else
                     arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]); 
              }
          } 
          int index= arr[m][n];
          char[] lcs=new char[index];
          //lcs[index]='\u0000';
          int i=m,j=n;
          while(i>0 && j>0)
          {
        	  if(first[i-1]==sec[j-1])
        	  {
        		  lcs[index-1]=first[i-1];
        		  i--;
        		  j--;
        		  index--;
        	  }
        	  else if(arr[i-1][j]>arr[i][j-1])
        		  i--;
        	  else
        		  j--;
          }
          String res="";
          for(char c:lcs)
        	  res+=c;
          return res;
	    }

	 public static void main(String[] args)
	 {
		 /*Input: text1 = "abcde", text2 = "ace" 
				 Output: 3  
				 Explanation: The longest common subsequence is "ace" and its length is 3.*/
		 /*Input: text1 = "abc", text2 = "abc"
                 Output: 3
                 Explanation: The longest common subsequence is "abc" and its length is 3.*/
		 /*Input: text1 = "abc", text2 = "def"
                 Output: 0
                 Explanation: There is no such common subsequence, so the result is 0.*/
		 
		 System.out.println(longestCommonSubsequence("abc","adef"));
		 
	 }
}
