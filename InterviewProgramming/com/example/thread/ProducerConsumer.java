package InterviewProgramming.com.example.thread;

class SharedBuffer{
    private int data;
    private boolean hasData=false;

    public synchronized void produce(int value) throws InterruptedException
    {
        while (hasData)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        data=value;
        hasData=true;
        System.out.println("produced "+data);
        notify();
    }
    public synchronized int consume() throws InterruptedException
    {
        while (!hasData)
        {
            try {
                wait();
            }catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        int value=data;
        hasData=false;
        System.out.println("consumed "+value);
        notify();
        return value;
    }
}
class Producer implements Runnable{
    private SharedBuffer sb;
    public Producer(SharedBuffer sb)
    {
        this.sb=sb;
    }
    @Override
    public void run()
    {
        int value=1;
        try{
            while (true)
            {
                sb.produce(value);
                value++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Consumer implements Runnable{
    private SharedBuffer sb;
    public Consumer(SharedBuffer sb)
    {
        this.sb=sb;
    }
    @Override
    public void run()
    {
        try{
            while (true)
            {
                sb.consume();
                Thread.sleep(1500);
            }
        }catch (InterruptedException e)
        {}
    }
}
public class ProducerConsumer {

    public static void main(String[] args)
    {
        SharedBuffer sb=new SharedBuffer();
        new Thread(new Producer(sb)).start();
        new Thread(new Consumer(sb)).start();
    }
}

