package JavaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the 
words: 9 / (4-1) = 3 spaces.*/
public class RearrangeSpace1592 {

	public String reorderSpaces(String text) {
		int cnt = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                ++cnt;
            }
        }
        String[] words = text.split("\\s+");
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (!"".equals(w)) {
                res.add(w);
            }
        }
        int m = res.size() - 1;
        if (m == 0) {
         //   return res.get(0) + " ".repeat(cnt);
        }
        //String ans = String.join(" ".repeat(cnt / m), res);
        //ans += " ".repeat(cnt % m);
        return "";//ans;
	}

	public static void main(String[] args) {
		
		String text = "  this   is  a sentence ";
		
		//String text = " practice   makes   perfect";
		
		System.out.println(new RearrangeSpace1592().reorderSpaces(text));

	}

}
