package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
	
	
	public static int numJewelsInStones(String jewels, String stones)
	{
		Map<Character,Integer> hm=new HashMap<>();
		
		for(int i=0;i<stones.length();i++)
		{
			char ch=stones.charAt(i);
			if(jewels.contains(""+ch))
				hm.put(ch,hm.containsKey(ch)?hm.get(ch)+1:1);
		}
		return hm.values().stream().reduce(0,(a,b)->a+b);
	}

	public static int numJewelsInStones_method2(String jewels, String stones)
	{
		int count=0;
		for(int i=0;i<stones.length();i++)
			if(jewels.indexOf(stones.charAt(i))>=0)
				count++;
		return count;
	}
	public static void main(String[] args) {
		
		String jewels = "aA";String stones = "aAAbbbb";
		
		System.out.println(numJewelsInStones(jewels, stones));
		
		System.out.println("=======");
		
		System.out.println(numJewelsInStones_method2(jewels, stones));

	}

}
