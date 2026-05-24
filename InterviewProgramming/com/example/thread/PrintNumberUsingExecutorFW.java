package InterviewProgramming.com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNumberUsingExecutorFW {

    static int n=1;
    static final int max=100;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        Runnable r = () -> {
            while (n <= max) {
                System.out.println(Thread.currentThread().getName() + " " + n);
                n++;
            }

        };

        for (int i = 0; i < 3; i++)
            es.submit(r);
    }

}
