package InterviewProgramming.com.example.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args)
    {
        CyclicBarrier barrier=new CyclicBarrier(3,()->{
            System.out.println("All threads reached barrier.now procedding...");//2. now barrier message will print
        });


        Runnable task=()->{
            try{
                System.out.println(Thread.currentThread().getName()+" reached barrier");//1.All 3 threads will execute till this point and wait for each other to reach
                barrier.await();                        //3. then await is over..
                System.out.println(Thread.currentThread().getName()+" continues.."); //4. then all thread will execute this
            }catch(Exception e)
               {
                   e.printStackTrace();
               }
        };


        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
/*
 * same happens here also what happens in countdown latch.
 * */