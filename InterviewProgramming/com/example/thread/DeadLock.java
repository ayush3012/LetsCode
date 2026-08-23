package InterviewProgramming.com.example.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Deadlock can happen :
 * 1. mutual exclusion:- resource can be used by one thread at a time. e.g synchronized block
 * 2. hold and wait : one thread already hold one resource and wait for another
 * 3.No preemption : resource cannot be forcibly taken away. only owning thread can release
 * 4. circular wait
 *
 * */
public class DeadLock {

    private static final Object lock1=new Object();
    private static final Object lock2=new Object();

    public static void main(String[] args)
    {
        Thread t1=new Thread(()->{
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+" acquired lock1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }

                    System.out.println(Thread.currentThread().getName()+" waiting for lock2");

                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName()+" acquired lock2");
                    }
                } //synchronized1 should end here

        });

        Thread t2=new Thread(()->{
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName()+" acquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                System.out.println(Thread.currentThread().getName()+" waiting for lock1");

                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+" acquired lock1");
                }

            }

        });

        t1.start();
        t2.start();


        try {
            Thread.sleep(500);
        }catch (Exception e){}

        ThreadMXBean bean= ManagementFactory.getThreadMXBean();
        long[] dlt=bean.findDeadlockedThreads();

        if(dlt!=null)
        {
            System.out.println("deadlock found between following threads..");
            for(long id:dlt)
            {
                ThreadInfo info=bean.getThreadInfo(id);
                System.out.println(info.getThreadName());
            }
        }else {
            System.out.println("no deadlock");
        }
    }
}
