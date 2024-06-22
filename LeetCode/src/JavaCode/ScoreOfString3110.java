package JavaCode;

/**
 * You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII 
 * values of adjacent characters.Return the score of s.
 * */
public class ScoreOfString3110 {
	
   public int scoreOfString(String s) {
        
	   int sum=0;
	   for(int i=0;i<s.length()-1;i++)
		   sum+=Math.abs(s.charAt(i)-s.charAt(i+1));
	
	   return sum;
    }

	public static void main(String[] args) {
		
		String s = "hello";
		
		System.out.println(new ScoreOfString3110().scoreOfString(s));

	}

}
