package InterviewProgramming.com.example.thread;

public class FooBarITC {
    int n;
    boolean footurn=true;

    FooBarITC(int n)
    {
        this.n=n;
    }

    public synchronized void Foo() throws Exception
    {
        for(int i=0;i<n;i++)
        {
            while (!footurn)
                wait();
            System.out.println("foo");
            footurn=false;
            notifyAll();
        }
    }
    public synchronized void Bar() throws Exception
    {
        for(int i=0;i<n;i++)
        {
            while (footurn)
                wait();
            System.out.println("bar");
            footurn=true;
            notifyAll();
        }
    }

    public static void main(String[] args) {

        FooBarITC fb=new FooBarITC(20);
        new Thread(()->{
            try {
                fb.Foo();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            try {
                fb.Bar();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
