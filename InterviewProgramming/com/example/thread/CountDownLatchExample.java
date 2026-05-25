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
