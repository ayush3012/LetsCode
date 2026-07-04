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
/*
* ExecutorService Interview Questions
Beginner
1. What is ExecutorService?

Expected Answer

Manages a pool of worker threads.
Decouples task submission from thread creation.
Improves performance by reusing threads.
2. Why should we use ExecutorService instead of creating threads manually?

Expected points

new Thread(() -> task()).start();

Problems

Expensive thread creation
No reuse
Difficult lifecycle management
Unlimited threads can cause OOM

ExecutorService solves these.

3. Difference between
execute()

submit()

Answer

execute()

returns void
cannot return result

submit()

returns Future
can return value
can return exception
4. What happens if a task throws exception?

execute()

Exception goes to thread's uncaught exception handler.

submit()

Exception is wrapped inside

ExecutionException

and thrown during

future.get();
5. Difference between Future and CompletableFuture

Future

blocking
cannot chain
cannot combine

CompletableFuture

async callbacks
chaining
combining
exception handling
non-blocking
Thread Pool Questions
6. Explain
Executors.newFixedThreadPool(5)

How many threads?

Answer

Maximum = 5

If 100 tasks arrive

first 5 execute
remaining 95 wait in queue
7. Difference

FixedThreadPool

CachedThreadPool

SingleThreadExecutor

WorkStealingPool

Expected answer:

Know each use case.

8. What queue does FixedThreadPool use?

Answer

LinkedBlockingQueue

(Unbounded)

Follow-up

What problem?

Answer

Memory can grow indefinitely.

9. What happens if queue becomes huge?

Possible

High memory
OOM
High latency
10. How do you create your own ThreadPoolExecutor?
new ThreadPoolExecutor(
    corePoolSize,
    maxPoolSize,
    keepAlive,
    TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(100)
);

Know every parameter.

11. Difference

corePoolSize

vs

maximumPoolSize

Very common.

12. What happens if
core threads busy
queue full
new task arrives

Expected sequence

Create core threads
Queue task
Queue full
Create extra threads
Reject
13. Explain RejectedExecutionHandler

Policies

AbortPolicy

CallerRunsPolicy

DiscardPolicy

DiscardOldestPolicy

14. Which rejection policy have you used?

Real-world answer

CallerRunsPolicy slows producer naturally.

15. Difference

shutdown()

shutdownNow()

16. What happens to running tasks during shutdown?
17. Difference

isShutdown()

isTerminated()

Performance Questions
18. How do you decide thread pool size?

CPU tasks

CPU cores + 1

IO tasks

Much larger.

19. Why not create 1000 threads?

Expected

Context switching
Memory
CPU overhead
20. Can thread pool cause deadlock?

Yes.

Example

Pool size = 2

Task1 waits for Task2

Task2 waits for Task3

Task3 never executes

Deadlock.

Scenario Questions
21. Design an API that calls
User Service
Payment Service
Reward Service

in parallel.

Expected

ExecutorService

or

CompletableFuture

22. How to wait for all tasks?
invokeAll()

Future.get()

CompletableFuture.allOf()
23. How to cancel running task?
future.cancel(true);
24. Difference

invokeAny()

invokeAll()

CompletableFuture Interview Questions
25. Why CompletableFuture introduced?

Limitations of Future

26. Difference

runAsync()

supplyAsync()

runAsync

No return

supplyAsync

Returns value

27. Default thread pool?

Answer

ForkJoinPool.commonPool()

28. How to use custom Executor?
ExecutorService executor =
Executors.newFixedThreadPool(5);

CompletableFuture.supplyAsync(
    () -> service.call(),
    executor
);
29. Difference

thenApply()

thenAccept()

thenRun()

Very common.

30. Difference

thenCompose()

thenCombine()

Expected

Compose

Dependent futures

Combine

Independent futures

31. Difference

thenApply()

vs

thenCompose()

Extremely common.

32. Explain
CompletableFuture.allOf()
33. Explain
CompletableFuture.anyOf()
34. How do exceptions propagate?

Know

exceptionally()

handle()

whenComplete()
35. Difference

handle()

exceptionally()

36. Difference

whenComplete()

handle()

37. How to recover from failure?
.exceptionally(ex -> defaultResponse)
38. Can CompletableFuture be cancelled?

Yes

cancel(true)
39. Difference

join()

get()

Answer

join()

Unchecked exception

get()

Checked exception

40. What happens if one future fails in
allOf()
Coding Questions
41. Fetch employee
Employee e = employeeService.get();
Salary s = salaryService.get();

Run in parallel.

42. Download

10 files

in parallel.

43. Call three microservices

Return first successful response.

44. Retry failed CompletableFuture.
45. Timeout CompletableFuture after 2 seconds.
46. Combine

Price

Tax

Discount

using CompletableFuture.

47. Build dashboard API

Calls

Orders
Users
Payments
Inventory

parallel.

48. Cancel all remaining futures when first fails.
49. Limit concurrency to 5 tasks.
50. Parallel file processing.
Tricky Questions (Very Common)
Q1

Why shouldn't we use

Executors.newFixedThreadPool()

in production?

Expected Answer

Because it uses an unbounded LinkedBlockingQueue. If tasks arrive faster than they are processed, the queue can grow indefinitely, leading to high memory usage or OutOfMemoryError. In production, it's often better to configure a ThreadPoolExecutor with a bounded queue and an appropriate rejection policy.

Q2

Why is CompletableFuture.join() considered dangerous?

It blocks the current thread. Calling join() too early or from a thread in the same limited thread pool that's needed to complete the future can reduce parallelism or even cause thread starvation.

Q3

Can CompletableFuture make code faster?

Not necessarily. It improves responsiveness by enabling asynchronous execution. Performance gains occur only when there is actual parallelizable work (for example, independent I/O-bound operations). Using it for sequential or CPU-bound work without proper design may add overhead.

Q4

Why avoid blocking calls inside CompletableFuture tasks?

If tasks submitted to a shared thread pool block for a long time (e.g., waiting on network or database calls), they occupy worker threads, reducing throughput and potentially starving other tasks. Consider dedicated executors for blocking operations.

Q5

What happens if a CompletableFuture task throws an exception and you never call get() or join()?

The exception is stored in the future. It won't automatically be thrown on another thread. If you never inspect the future or attach an exception handler, the failure can go unnoticed.

* */

/*
*
* ExecutorService executor = new ThreadPoolExecutor(
        2,                              // Core pool size
        5,                              // Maximum pool size
        60,                             // Keep alive time
        TimeUnit.SECONDS,               // Time unit
        new ArrayBlockingQueue<>(100),  // Work queue
        Executors.defaultThreadFactory(), // Thread factory
        new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
);
*
* it initially created only 2 thread( core pool size), if task exceeds in ArrayBlockingQueue (here more than
* 100) then more thread upto max pool size will be created and if task continues to grow then it uses
* RejectedExecutionPolicy . by default is abort policy
* */