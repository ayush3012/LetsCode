package JavaCode;

public class CapitalUse {

	public static boolean detectCapitalUse(String word) {
        
		  boolean flg=false;
	        if(word.toUpperCase().equals(word) || word.toLowerCase().equals(word))
	        	flg=true;
	        else if((word.charAt(0)>='A' || word.charAt(0)<='Z') && word.substring(1).toLowerCase().equals(word.substring(1)) )
	        	flg=true;
	        return flg;
	    }
	public static void main(String[] args) 
	{
		System.out.println(detectCapitalUse("FlaG"));
	}
}
