package InterviewProgramming.com.example.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/*
* add and offer method is in queue . so we are using put method which is in blockingqueue
* which will block the thread if capacity is full
*
* poll method is in queue . use take method which will block queue if queue is empty
* */
public class ProducerConsumerBlockingQueue {

    public static void main(String[] args)
    {
        BlockingQueue<Integer> q=new LinkedBlockingQueue<>(5);

        Runnable producer=()->{
            int val=1;
            while (true)
            {
                try {
                    System.out.println("produced:- "+val);
                    q.put(val++);         // put method blocks queue if queue is full ,offer() returns false if full
                    Thread.sleep(100);
                }catch(InterruptedException e){}
            }
        };
        Runnable consumer=()->{
            while (true)
            {
                try {
                    int val=q.take();    // take method blocks if queue is empty, poll() return null if empty
                    System.out.println("consumed... "+val);
                    Thread.sleep(100);
                }catch(InterruptedException e){}
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
/*
*  static void ProducerConsumerUsingExecutor() {

        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("produced:" + i);
                try {
                    bq.put(i);
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
        });

        service.submit(() -> {
            while (true) {
                int a = bq.take();
                System.out.println("consumed: " + a);
            }
        });

        service.shutdown();

    }
* */