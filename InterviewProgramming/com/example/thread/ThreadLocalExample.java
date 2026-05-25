package InterviewProgramming.com.example.thread;

public class ThreadLocalExample {

    static ThreadLocal<Integer> tl=new ThreadLocal<>();// each thread has its own value and no race condition

    public static void main(String[] args) {

        Runnable task=()->{
            tl.set((int)(Math.random()*100));
            System.out.println(Thread.currentThread().getName()+" "+tl.get()+" value acquired");
        };

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        Thread t3=new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
