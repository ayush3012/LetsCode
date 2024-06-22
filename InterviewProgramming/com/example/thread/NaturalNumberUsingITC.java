package com.example.thread;

public class NaturalNumberUsingITC {

	public static void main(String[] args) {

		final Object lock=new Object();

		new Thread(()-> {

			try {
				synchronized(lock)
				{
					int i=0;
					while(i<50)
					{
						System.out.print(i+" ");
						lock.notify();
						lock.wait();
						i+=2;
					}
				}

			}catch(Exception e) {} 
		}).start();
		new Thread(()-> {
			try {
				synchronized(lock)
				{
					int i=1;
					while(i<50)
					{
						System.out.print(i+" ");
						lock.notify();
						lock.wait();
						i+=2;
					}
				}

			}catch(Exception e) {} }).start();
	}

}
