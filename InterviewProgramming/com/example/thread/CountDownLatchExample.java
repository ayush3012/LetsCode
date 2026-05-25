package InterviewProgramming.com.example.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {


    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch latch=new CountDownLatch(3);

        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+" started...");
            latch.countDown();
        };

        new Thread(task).start();  // countdown 2
        new Thread(task).start();  // countdown 1
        new Thread(task).start();  // countdown 0

        latch.await();  // main thread will stop here until it sees countdown=0 after that it goes to line 23

        System.out.println("All thread started.."+Thread.currentThread().getName()+" continues..");
    }
}
/*
* if countdownlatch(5) and we started 3 threads only so countdown will get at 2 and never reaches 0 and
* main thread will be blocked forever . deadlock situation
*
* if countdownlatch(3) and we started 5 threads -> only 3 thread will make countdown to 0 and latch.awaits
* will be broken and all thread will run as usual and there will be no error.
*
* */