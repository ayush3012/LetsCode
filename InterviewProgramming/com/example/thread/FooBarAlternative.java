package com.example.thread;

import java.util.concurrent.Semaphore;

public class FooBarAlternative {
	
	private int n;

    public FooBarAlternative(int n) {
        this.n = n;
    }
    private Semaphore sem1=new Semaphore(1);
    private Semaphore sem2=new Semaphore(0);
    public void foo(Runnable printFoo) throws InterruptedException {
       
        for (int i = 0; i < n; i++) {
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            sem1.acquire();
        	printFoo.run();
            sem2.release();
        }
        

    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
           sem2.acquire();
        	printBar.run();
           sem1.release(); 
    }
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
