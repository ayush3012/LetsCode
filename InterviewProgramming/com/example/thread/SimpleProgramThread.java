package com.example.thread;


class MyThread extends Thread{
	public void run()
	{
		for(int i=0;i<5;i++)
			System.out.println("Mythread running");
	}
}
public class SimpleProgramThread {

	public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.start();
		for(int i=0;i<5;i++)
			System.out.println("SimpleProgram running");
		//mt.start();
	}
}
