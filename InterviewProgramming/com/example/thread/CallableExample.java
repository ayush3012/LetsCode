package InterviewProgramming.com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) throws Exception
    {
        ExecutorService es= Executors.newSingleThreadExecutor();

        Callable<Integer> c=()->{return 10*2;};   // call method in callable functional interface returns
                                                  // future objects

        Future<Integer> f=es.submit(c);

        System.out.println(f.get());

        es.shutdown();

    }
}
