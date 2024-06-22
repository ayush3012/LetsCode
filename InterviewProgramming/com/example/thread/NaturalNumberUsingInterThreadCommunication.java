package com.example.thread;

class Evens implements Runnable{

	@Override
	public void run()
	{
		try {
			synchronized(this)
			{
				int i=0;
				while(i<50)
				{
					System.out.print(i+" ");
					this.notify();
					this.wait(100);
					i+=2;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class Odds implements Runnable{

	@Override
	public void run()
	{
		try {
			synchronized(this)
			{
				int i=1;
				while(i<50)
				{
					System.out.print(i+" ");
					this.notify();
					this.wait(100);
					i+=2;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public class NaturalNumberUsingInterThreadCommunication {

	
	public static void main(String[] args) {

		new Thread(new Evens()).start();
		new Thread(new Odds()).start();

	}

}
