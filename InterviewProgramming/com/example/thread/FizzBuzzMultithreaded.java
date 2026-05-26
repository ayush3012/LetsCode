package com.example.thread;

import java.util.function.IntConsumer;

class FizzBuzzz {
    private int n;
    private int curr;

    public FizzBuzzz(int n) {
        this.n = n;
        this.curr=1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz() throws InterruptedException {

        while (curr<=n)
        {
            while (curr<=n && !(curr %3 ==0 && curr%5!=0))
                wait();
            if(curr<=n)
            {
                System.out.println("fizz");
                curr++;
                notifyAll();
            }

        }

    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz() throws InterruptedException {
        while (curr<=n)
        {
            while (curr<=n && !(curr%3!=0 && curr%5==0))
                wait();
            if(curr<=n)
            {
                System.out.println("buzz");
                curr++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz() throws InterruptedException {

        while (curr<=n)
        {
            while (curr<=n && !(curr%15==0))
                wait();
            if(curr<=n)
            {
                System.out.println("fizzbuzz");
                curr++;
                notifyAll();
            }
        }
    }
   public synchronized void number() throws InterruptedException
   {
       while (curr<=n)
       {
           while (curr<=n && (curr%3==0 || curr%5==0))
               wait();
           if (curr<=n)
           {
               System.out.println(curr);
               curr++;
               notifyAll();
           }
       }
   }
}
public class FizzBuzzMultithreaded {

	public static void main(String[] args) {

        FizzBuzzz fb=new FizzBuzzz(15);

        new Thread(()->{
            try {
                fb.fizz();
            }catch (Exception e){}
        }).start();

        new Thread(()->{
            try {
                fb.buzz();
            }catch (Exception e){}
        }).start();

        new Thread(()->{
            try {
                fb.number();
            }catch (Exception e){}
        }).start();

	}

}
