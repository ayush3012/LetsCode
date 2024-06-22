package com.example.thread;

class Even implements Runnable{
	
	@Override
	public void run()
	{
		int i=2;
		while(true)
		{
			try {
				Thread.sleep(2000);
				System.out.print(i+" ");
				i+=2;
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
class Odd implements Runnable{
	
	@Override
	public void run()
	{
		int i=1;
		while(true)
		{
			try {
				Thread.sleep(2000);
				System.out.print(i+" ");
				i+=2;
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
public class NaturalNumber {
	
	public static void printNaturalNumber(Even e,Odd o)
	{
		new Thread(e).start();
		new Thread(o).start();
	}

	public static void main(String[] args) {
		
		Even e=new Even();
		Odd o=new Odd();
		

		printNaturalNumber(e, o);
	}

}
