package InterviewProgramming.com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Oneto100Using3Thread {

    static int num = 1;
    static Object lock = new Object();

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i <3; i++) {
            final int threadId = i;

            es.submit(() -> {
                try {
                    while (true)
                    {
                        synchronized (lock)
                        {
                            while (num <= 100 && (num-1) % 3 != threadId)
                                lock.wait();
                            if (num > 100) {
                                lock.notifyAll();
                                break;
                            }
                            System.out.println(Thread.currentThread().getName() + " -> " + num);
                            num++;
                            lock.notifyAll();
                        }
                    }
                } catch (Exception e) {}
            });
        }

        es.shutdown();
    }
}
