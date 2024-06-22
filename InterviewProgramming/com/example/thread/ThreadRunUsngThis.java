package com.example.thread;

public class ThreadRunUsngThis implements Runnable {

	@Override
	public void run() {
		System.out.println("running...");

	}

	public static void main(String[] args) {
		ThreadRunUsngThis trut=new ThreadRunUsngThis();
		//Thread t=new Thread(this);   "this" can not be used in static method
		Thread t=new Thread(trut);
		t.start();
	}

}
