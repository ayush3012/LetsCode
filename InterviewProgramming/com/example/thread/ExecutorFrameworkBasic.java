package InterviewProgramming.com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameworkBasic {

    public static void main(String[] args)
    {
        ExecutorService esFP= Executors.newFixedThreadPool(3);  // this will create 3 threads and only those
                                                                      // 3 threads will execute 5 tasks

        for(int i=0;i<=5;i++)
        {
            int taskId=i;
            esFP.submit(()-> System.out.println("Task "+taskId+" is executed by fixed pool threads"+Thread.currentThread().getName()));
        }
        esFP.shutdown();


        System.out.println("Execution of cache pool starts----");

        ExecutorService esCP= Executors.newCachedThreadPool();// it will create as per requirement like here 6 created
                                                             // and every thread pick one task


        for(int i=10;i<=15;i++)
        {
            int taskId=i;
            esCP.submit(()-> System.out.println("Task "+taskId+" is executed by cached pool threads"+Thread.currentThread().getName()));
        }
        esCP.shutdown();
    }
}
/*
* 1. Executor -> interface but not a functional interface since has only one method but can behave like one
*                method : void execute(Runnable r)
*
* 2. ExecutorService -> extends interface Executor.
*                      method: Future submit(Runnable r)
*                              Future submit(Callable c)  //Runnable and callable both are functional interface
*
* 3. Executors -> class has static method like newFixedThreadPool(int numberOfThreads),newCachedThreadPool
*
*                 newFixedThreadPool -> fixed number of threads and tasks are enqueued if threads are busy
*                 newCachedThreadPool -> dynamically create thread based on requirenment maximum upto
*                                        Integer.MAX_VALUE
*                  syntax:: ExecutorService executor = Executors.newCachedThreadPool();
*
* REMEMBER to use shutdown: threads are usually non deamon and can live for longer which wakes JVM up and can utilise
*                           CPU
*
* ===============In above example=======================
*    created pool of 3 threads and submitted 5 task. so free threads pick task and execute
*
* */