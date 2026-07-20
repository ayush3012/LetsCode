package InterviewProgramming.com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintZeroEvenOdd1116 {

    static int curr=0;
    static final int n=9;
    static int turn=0;
    static final Object lock=new Object();

    public static void main(String[] args) throws InterruptedException{

        ExecutorService service= Executors.newFixedThreadPool(3);

        for(int i=0;i<n;i++)
        {
            final int tid=i;
            service.submit(()->{
                try{
                    while (true)
                    {
                        synchronized (lock)
                        {
                            while (curr<=n && turn!=tid)
                                lock.wait();
                            if(curr>n)
                            {
                                lock.notifyAll();
                                break;
                            }
                           if(turn==0)
                           {
                               System.out.print("0");
                               turn=curr%2!=0?1:2;
                               lock.notifyAll();
                           }
                           else if(turn==1)
                           {
                               System.out.print(curr+1);
                               curr++;
                               turn=0;
                               lock.notifyAll();
                           }
                           else
                           {
                               System.out.print(curr+1);
                               curr++;
                               turn=0;
                               lock.notifyAll();
                           }
                        }
                    }
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            });
        }

        service.shutdown();
    }
}
