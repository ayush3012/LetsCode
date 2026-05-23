package InterviewProgramming.com.example.thread;

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
                synchronized (lock1)
                {
                    System.out.println("thread1 acquired lock1");
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){}
                }

            System.out.println("thread1 waiting for lock2");

                synchronized (lock2)
                {
                    System.out.println("thread1 acquired lock2");
                }

        });

        Thread t2=new Thread(()->{
            synchronized (lock2)
            {
                System.out.println("thread2 acquired lock2");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){}
            }

            System.out.println("thread2 waiting for lock1");

            synchronized (lock1)
            {
                System.out.println("thread2 acquired lock1");
            }

        });

        t1.start();
        t2.start();
    }
}
