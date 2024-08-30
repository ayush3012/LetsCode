package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class MaximumBalloon1189 {

	public int maxNumberOfBalloons(String text) {

		Map<Character,Integer> hm=new HashMap<>();
		int count=0;
		for(char c:text.toCharArray())
			hm.put(c,!hm.containsKey(c)?1:hm.get(c)+1);

		if(hm.containsKey('b') && hm.containsKey('a') &&hm.containsKey('l') && hm.containsKey('o') && hm.containsKey('n'))
		{
			while(hm.get('b')>=1 && hm.get('a')>=1 && hm.get('l')>=2 && hm.get('o')>=2 && hm.get('n')>=1)
			{
				count++;
				hm.put('b', hm.get('b')-1);
				hm.put('a', hm.get('a')-1);
				hm.put('l', hm.get('l')-2);
				hm.put('o', hm.get('o')-2);
				hm.put('n', hm.get('n')-1);
			}
		}

		return count;
	}

	public static void main(String[] args) {

		String text = "leetcode";

		System.out.println(new MaximumBalloon1189().maxNumberOfBalloons(text));

	}

}
