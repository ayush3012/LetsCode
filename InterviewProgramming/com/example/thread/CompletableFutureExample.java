package InterviewProgramming.com.example.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    static void BasicCompletable()
    {
        CompletableFuture<Void> future1=CompletableFuture.runAsync(()->{
            System.out.println("Running async task using runAsync  "+Thread.currentThread().getName());
        });
        future1.join();  //it belongs to completableFuture and can thorw Unchecked exception
        //future.get();  //it belongs to future and throws checked exception needs try-catch

        /*runAsync -> returns nothing , CompletableFuture<Void>
          supplyAsync -> returns something
        * */

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Runnning Async task using" +
                " supplyAsync "+ Thread.currentThread().getName());

        String result = future2.join();  // returns "Hello"

        System.out.println(result);
    }

    static void Chaining()
    {
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->10).thenApply(i->i*2)
                .thenApply(i->i+5).thenAccept(System.out::println);

        /**
         * Here we have used supplyAsync because we need to return something so that we can apply operation on that
         * output.
         *
         * if we use thenApplyAsync then we can not predict output because which thread will execute first and give
         * result we will not be sure
         * */
        CompletableFuture<Void> future2=CompletableFuture.supplyAsync(()->10).thenApplyAsync(i->i*2)
                .thenApplyAsync(i->i+5).thenAcceptAsync(System.out::println);
    }

    static void combineTwoFuture() throws Exception
    {
        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(()->10);
        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(()->50);

        CompletableFuture<Integer> res=f1.thenCombine(f2,(a,b)->a+b);

        System.out.println(res.get());
    }

    static void CombineThreeAPI() throws Exception
    {
        CompletableFuture<String> f1=CompletableFuture.supplyAsync(()->"A");
        CompletableFuture<String> f2=CompletableFuture.supplyAsync(()->"B");
        CompletableFuture<String> f3=CompletableFuture.supplyAsync(()->"C");

        CompletableFuture<String> res=f1.thenCombine(f2,(a,b)->a+" - "+b)
                .thenCombine(f3,(a,b)->a+" : "+b);

        System.out.println(res.get());
    }
    public static void main(String[] args) throws Exception {
       BasicCompletable();

       Chaining();

       combineTwoFuture();

       CombineThreeAPI();
    }
}
