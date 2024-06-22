package com.example.thread;

import java.util.ArrayList;
import java.util.List;

/*"fizzbuzz" if i is divisible by 3 and 5,
"fizz" if i is divisible by 3 and not 5,
"buzz" if i is divisible by 5 and not 3, or
i if i is not divisible by 3 or 5.
*/
public class FizzBuzz {
	
	public static void FizzBuzzSequence(int n)
	{
		List<String> al=new ArrayList<>();
		for(int i=1;i<n;i++)
			al.add(
					i%15==0?"fizzbuzz":
					i%3==0?"fizz":
					i%5==0?"buzz":String.valueOf(i)	
					
				);
		al.forEach(i->System.out.print(i+" "));
	}

	public static void main(String[] args) {
		
		int n=15;
		
		FizzBuzzSequence(n);
	}

}
