package InterviewProgramming.com.example.thread;

public class RaceCondition {
    private static int count=0;

    public static void main(String[] args) throws Exception
    {
        Thread t1=new Thread(()->{
            for(int i=0;i<10000;i++)
                count++;
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<10000;i++)
                count++;
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final count "+count);  // expected 2000, actual: anything less than 20000

        /*
        * fix:
        * declare one synchronized method to increase count
        * public synchronized static void increment(){ count++; }
        *
        * instead of count++ replce with increment()
        *
        * better solution
        * private static AtomicInteger count=new AtomicInteger(0);
        *
        * replace count++ with count.incrementAndGet();
        *
        * AtomicInteger uses CAS (compare and swap) , cpu level atomic instruction
        * but synchronized uses locking
        *  */
    }
}
