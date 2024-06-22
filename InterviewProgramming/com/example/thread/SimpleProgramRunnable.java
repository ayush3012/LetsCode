package com.example.thread;


class MyThread2 implements Runnable{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("Mythread2 running");
			//Thread.yield();
		}
	}
}
public class SimpleProgramRunnable {

	public static void main(String[] args) {
		MyThread2 mt2=new MyThread2();
		Thread t=new Thread(mt2);
		//Thread t=new Thread();
		t.setPriority(10);
		t.start();
		for(int i=0;i<5;i++)
		{
			System.out.println("SimpleProgramRunnable running");
			Thread.yield();
		}
		//t.start();    can not start thread twice
		
	}

}
