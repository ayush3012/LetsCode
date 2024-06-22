package com.example.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Display{
	Lock l=new ReentrantLock();
	public  void wish(String name) throws InterruptedException
	{
		do {
			if(l.tryLock(5000,TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName()+" got chance");
				for(int i=0;i<5;i++)
				{
					System.out.print("Good Morning ");
					try {
						Thread.currentThread().sleep(1000);
					}
					catch(InterruptedException ie) {
						System.out.println(ie.getStackTrace());
					}
					System.out.println(name);
				}
				l.unlock();
			}
			else
			{
				System.out.println(Thread.currentThread().getName()+" waiting..");
			}
		}while(Thread.currentThread().holdsLock(this));
	}
}
class LocalThread extends Thread{
	Display d;
	String name;
	public LocalThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	@Override
	public void run()
	{
		try {
			d.wish(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
public class LockDemo {

	public static void main(String[] args) {

		Display d=new Display();
		LocalThread lt1=new LocalThread(d,"ayush");
		LocalThread lt2=new LocalThread(d,"karna");
		lt1.start();
		lt2.start();
	}

}
