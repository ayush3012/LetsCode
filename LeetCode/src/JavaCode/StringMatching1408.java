package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.*/
public class StringMatching1408 {
	
	public List<String> stringMatching(String[] words) {

		Arrays.sort(words);
		List<String> al=new ArrayList<>();
		for(int i=0;i<words.length;i++)
		{
			String s=words[i];
			for(int j=0;j<words.length;j++)
				if(i!=j && words[j].contains(s))
				{
					al.add(s);
					break;
				}

		}
		return al;
	}

	public static void main(String[] args) {
		
		//String[] words = {"mass","as","hero","superhero"};
		
		//String[] words = {"leetcode","et","code"};
		
		String[] words = {"blue","green","bu"};
		
		List<String> al=new ArrayList<>();
		al=new StringMatching1408().stringMatching(words);
		
		al.forEach(i->System.out.print(i+" "));

	}

}
