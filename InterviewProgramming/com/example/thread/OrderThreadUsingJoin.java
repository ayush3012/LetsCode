package com.example.thread;


public class OrderThreadUsingJoin {

	
	public static class ParallelTask implements Runnable{
		 Thread pre;
		 public void setPre(Thread t)
		 {
			 this.pre=t;
		 }
		 @Override
		 public void run()
		 {
			 System.out.println("Thread "+Thread.currentThread().getName()+" started..");
			 if(pre!=null)
			 {
				 try {
				 pre.join();
				 }catch(InterruptedException e)
				 {
					 System.out.println(e.getStackTrace());
				 }
			 }
			 System.out.println("Thread "+Thread.currentThread().getName()+" Finished");
		 }
	}
	public static void main(String[] args)
	{
		ParallelTask task1=new ParallelTask();
		ParallelTask task2=new ParallelTask();
		ParallelTask task3=new ParallelTask();
		ParallelTask task4=new ParallelTask();
		ParallelTask task5=new ParallelTask();
		Thread t1=new Thread(task1,"thread1");
		Thread t2=new Thread(task2,"thread2");
		Thread t3=new Thread(task3,"thread3");
		Thread t4=new Thread(task4,"thread4");
		Thread t5=new Thread(task5,"thread5");
		task3.setPre(t2);
		task2.setPre(t1);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
