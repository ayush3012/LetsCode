package JavaCode;

import java.util.HashSet;
import java.util.Set;

/**
 A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b. For example,
  5655359 and 56554 have a common prefix 565 while 1223 and 43456 do not have a common prefix.
 */
public class LongestCommonPrefix3043 {

	public int longestCommonPrefix(int[] arr1, int[] arr2) {

		Set<Integer> hs=new HashSet<>();
		for(int i:arr1)
		{
			while(i>0)
			{
				hs.add(i);
				i/=10;
			}
		}
		int max=0;
		for(int i:arr2)
		{
			while(i>0) {
				int n=(""+i).length();
				if(n<=max)
					break;
				if(hs.contains(i))
					max=n;
				i/=10;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr1 = {1,10,100};int[] arr2 = {1000};

		//int[] arr1 = {1,2,3};int[] arr2 = {4,4,4};

		//int[] arr1 = {10};int[] arr2 = {17,11};

		System.out.println(new LongestCommonPrefix3043().longestCommonPrefix(arr1, arr2));

	}

}
