package JavaCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class DecodeTheMessage {

public static String decodeMessage(String key, String message) {
        
	    char ch='a';
	    key=key.replace(" ","");
	    String res="";
	    Map<Character,Character> lhm=new LinkedHashMap<>();
	    for(int i=0;i<key.length();i++)
	    	if(!lhm.containsKey(key.charAt(i)))
	    	   lhm.put(key.charAt(i),ch++);
	    
	    for(int i=0;i<message.length();i++)
	      res+=lhm.containsKey(message.charAt(i))?lhm.get(message.charAt(i)):" ";
	    
	    return res;
    }
	public static void main(String[] args) {
		
		String key = "the quick brown fox jumps over the lazy dog";
		String message = "vkbs bs t suepuv";
		
		System.out.println(decodeMessage(key, message));

	}

}
