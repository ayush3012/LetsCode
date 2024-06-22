package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class WordContainingCharacter2942 {
	
public List<Integer> findWordsContaining(String[] words, char x) {
        
	  List<Integer> list=new ArrayList<Integer>();
	  
	  for(int i=0;i<words.length;i++)
		  if(words[i].indexOf(x)>=0)
			  list.add(i);
	  return list;
	     
    }

	public static void main(String[] args) {
		
		//String[] words= {"abc","bcd","aaaa","cbc"};
		//char x='a';
		
		String[] words= {"leet","code"};
		char x='e';
		List<Integer> list=new ArrayList<Integer>();
		list=new WordContainingCharacter2942().findWordsContaining(words, x);
		
		list.forEach(i->System.out.print(i+" "));

	}

}
