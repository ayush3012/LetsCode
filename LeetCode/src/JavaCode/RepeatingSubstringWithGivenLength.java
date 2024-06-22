package JavaCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RepeatingSubstringWithGivenLength {
	
	public static List<String> RepeatingSubstring(String s)
	{
		List<String> al=new ArrayList<>();
		Map<String,Integer> lhm=new LinkedHashMap<>();
		for(int i=0;i<=s.length()-10;i++)
		{
			String str=s.substring(i,i+10);
			lhm.put(str, lhm.getOrDefault(str,0)+1);
		}
		for(Map.Entry<String,Integer> e:lhm.entrySet())
			if(e.getValue()>1)
				al.add(e.getKey());
		return al;
	}

	public static void main(String[] args) {
		
		String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> al=new ArrayList<>();
		al=RepeatingSubstring(s);
		al.forEach(i->System.out.println(i));
	}

}
