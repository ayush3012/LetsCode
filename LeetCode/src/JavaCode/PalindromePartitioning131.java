package JavaCode;

import java.util.ArrayList;
import java.util.List;

/*Given a string s, partition s such that every substring of the partition is a palindrome.Return all possible palindrome
 *  partitioning of s.
 *  Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]*/
public class PalindromePartitioning131 {
	
	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
	    dfs(s, 0, new ArrayList<>(), ans);
	    return ans;	
	}
	private void dfs(final String s, int start, List<String> path, List<List<String>> ans) {
	    if (start == s.length()) {
	      ans.add(new ArrayList<>(path));
	      return;
	    }

	    for (int i = start; i < s.length(); ++i)
	      if (isPalindrome(s, start, i)) {
	        path.add(s.substring(start, i + 1));
	        dfs(s, i + 1, path, ans);
	        path.remove(path.size() - 1);
	      }
	  }
	private boolean isPalindrome(final String s, int l, int r) {
	    while (l < r)
	      if (s.charAt(l++) != s.charAt(r--))
	        return false;
	    return true;
	  }

	public static void main(String[] args) {
		
		String s = "aab";
		
		List<List<String>> al=new ArrayList<>();
		
		al=new PalindromePartitioning131().partition(s);
		System.out.println(al.toString());

	}

}
