package com.example.java8;

import java.util.stream.IntStream;

public class StreamVsParallelStream {

	/*
	 * Comparing streams to loops First, we want to find out how a stream’s bulk
	 * operation compares to a regular, traditional for-loop. Is it worth using
	 * streams in the first place (for performance reasons)?
	 * 
	 * The sequence which we will use for the benchmark is an int-array filled with
	 * 500,000 random integral values. In this array we will search for the maximum
	 * value.
	 * 
	 * Here is the traditional solution with a for-loop:
	 * 
	 * int[] a = ints; int e = ints.length; int m = Integer.MIN_VALUE; for(int i=0;
	 * i < e; i++) if(a[i] > m) m = a[i]; Here is the solution with a sequential
	 * IntStream:
	 * 
	 * int m = Arrays.stream(ints) .reduce(Integer.MIN_VALUE, Math::max); We
	 * measured on an outdated hardware (dual core, no dynamic overclocking) with
	 * proper warm-up and all it takes to produce halfway reliable benchmark
	 * figures. This was the result in that particular context:
	 * 
	 * int-array, for-loop : 0.36 ms int-array, seq. stream: 5.35 ms The result is
	 * sobering: the good old for-loop is 15 times faster than the sequential
	 * stream. How disappointing! Years of development effort spent on building
	 * streams for java 8 and then this ?!?!? But, wait! Before we conclude that
	 * streams are abysmally slow let us see what happens if we replace the
	 * int-array by an ArrayList<Integer>.
	 * 
	 * Here is the for-loop:
	 * 
	 * int m = Integer.MIN_VALUE; for (int i : myList) if (i>m) m=i; Here is the
	 * stream-based solution:
	 * 
	 * int m = myList.stream() .reduce(Integer.MIN_VALUE, Math::max); These are the
	 * results:
	 * 
	 * ArrayList, for-loop : 6.55 ms ArrayList, seq. stream: 8.33 ms Again, the
	 * for-loop is faster that the sequential stream operation, but the difference
	 * on an ArrayList is not nearly as significant as it was on an array.
	 * 
	 * Let’s think about it. Why do the results differ that much? There are several
	 * aspects to consider.
	 * 
	 * First, access to array elements is very fast. It is an index-based memory
	 * access with no overhead whatsoever. In other words, it is a plain
	 * down-to-the-metal memory access. Elements in a collection such as ArrayList
	 * on the other hand are accessed via an iterator and the iterator inevitably
	 * adds overhead. Plus, there is the overhead of boxing and unboxing collection
	 * elements whereas int-arrays use plain primitive type ints. Essentially, the
	 * measurements for the ArrayList are dominated by the iteration and boxing
	 * overhead whereas the figures for the int-array illustrate the advantage of
	 * for-loops.
	 * 
	 * Secondly, had we seriously expected that streams would be faster than plain
	 * for-loops? Compilers have 40+ years of experience optimizing loops and the
	 * virtual machine’s JIT compiler is especially apt to optimize for-loops over
	 * arrays with an equal stride like the one in our benchmark. Streams on the
	 * other hand are a very recent addition to Java and the JIT compiler does not
	 * (yet) perform any particularly sophisticated optimizations to them.
	 * 
	 * Thirdly, we must keep in mind that we are not doing much with the sequence
	 * elements once we got hold of them. We spend a lot of effort trying to get
	 * access to an element and then we don’t do much with it. We just compare two
	 * integers, which after JIT compilation is barely more than one assembly
	 * instruction. For this reason, our benchmarks illustrate the cost of element
	 * access – which need not necessarily be a typical situation. The performance
	 * figures change substantially if the functionality applied to each element in
	 * the sequence is cpu intensive. You will find that there is no measurable
	 * difference any more between for-loop and sequential stream if the
	 * functionality is heavily cpu bound.
	 * 
	 * Join us at JAX London – the Conference for Java & Software innovators. Get a
	 * 10% discount off your ticket with this code: MP_JCG10
	 * 
	 * The ultimate conclusion to draw from this benchmark experiment is NOT that
	 * streams are always slower than loops. Yes, streams are sometimes slower than
	 * loops, but they can also be equally fast; it depends on the circumstances.
	 * The point to take home is that sequential streams are no faster than loops.
	 * If you use sequential streams then you don’t do it for performance reasons;
	 * you do it because you like the functional programming style.
	 * 
	 * So, where is the performance improvement streams were invented for? So far we
	 * have only compared loops to streams. How about parallelization? The point of
	 * streams is easy parallelization for better performance.
	 * 
	 * Comparing sequential streams to parallel streams As a second experiment, we
	 * want to figure out how a sequential stream compares to a parallel stream
	 * performance-wise. Are parallel stream operations faster than sequential ones?
	 * 
	 * We use the same int-array filled with 500,000 integral values. Here is the
	 * sequential stream operation:
	 * 
	 * int m = Arrays.stream(ints) .reduce(Integer.MIN_VALUE, Math::max); This is
	 * the parallel stream operation:
	 * 
	 * int m = Arrays.stream(ints).parallel() .reduce(Integer.MIN_VALUE, Math::max);
	 * Our expectation is that parallel execution should be faster than sequential
	 * execution. Since the measurements were made on a dual-core platform parallel
	 * execution can be at most twice as fast as sequential execution. Ideally, the
	 * ratio sequential / parallel performance should be 2.0, Naturally, parallel
	 * execution does introduce some overhead for splitting the problem, creating
	 * subtasks, running them in multiple threads, gathering their partial results,
	 * and producing the overall result. The ratio will be less than 2.0, but it
	 * should come close.
	 * 
	 * These are the actual benchmark results:
	 * 
	 * sequential parallel seq./par. int-array 5.35 ms 3.35 ms 1.60 The reality
	 * check via our benchmark yields a ratio (sequential / parallel) of only 1.6
	 * instead of 2.0, which illustrates the amount of overhead that is involved in
	 * going parallel and how (well or poorly) it is overcompensated (on this
	 * particular platform).
	 * 
	 * You might be tempted to generalise these figures and conclude that parallel
	 * streams are always faster than sequential streams, perhaps not twice as fast
	 * (on a dual core hardware), as one might hope for, but at least faster.
	 * However, this is not true. Again, there are numerous aspects that contribute
	 * to the performance of a parallel stream operation.
	 * 
	 * One of them is the splittability of the stream source. An array splits
	 * nicely; it just takes an index calculation to figure out the mid element and
	 * split the array into halves. There is no overhead and thus barely any cost of
	 * splitting. How easily do collections split compared to an array? What does it
	 * take to split a binary tree or a linked list? In certain situation you will
	 * observe vastly different performance results for different types of
	 * collections.
	 * 
	 * Another aspect is statefulness. Some stream operations maintain state. An
	 * example is the distinct() operation. It is an intermediate operation that
	 * eliminates duplicates from the input sequence, i.e., it returns an output
	 * sequence with distinct elements. In order to decide whether the next element
	 * is a duplicate or not the operation must compare to all elements it has
	 * already encountered. For this purpose it maintains some sort of data
	 * structure as its state. If you call distinct() on a parallel stream its state
	 * will be accessed concurrently by multiple worker threads, which requires some
	 * form of coordination or synchronisation, which adds overhead, which slows
	 * down parallel execution, up to the extent that parallel execution may be
	 * significantly slower than sequential execution.
	 * 
	 * With this in mind it is fair to say that the performance model of streams is
	 * not a trivial one. Expecting that parallel stream operations are always
	 * faster than sequential stream operations is naive. The performance gain, if
	 * any, depends on numerous factors, some of which I briefly mentioned above. If
	 * you are familiar with the inner workings of streams you will be capable of
	 * coming up with an informed guess regarding the performance of a parallel
	 * stream operation. Yet, you need to benchmark a lot in order to find out for a
	 * given context whether going parallel is worth doing or not. There are indeed
	 * situations in which parallel execution is slower than sequential execution
	 * and blindly using parallel streams in all cases can be downright counter-
	 * productive.
	 * 
	 * The realisation is: Yes, parallel stream operations are easy to use and often
	 * they run faster than sequential operations, but don’t expect miracles. Also,
	 * don’t guess; instead, benchmark a lot.
	 */
	public static void main(String[] args)
	{
		long s=System.currentTimeMillis();
		IntStream.range(0,100).forEach(i->System.out.print(i+" "));
		long e=System.currentTimeMillis();
		System.out.println("\nTime taken "+(e-s));
		System.out.println("*************");
		long s1=System.currentTimeMillis();
		IntStream.range(0,100).parallel().forEach(i->System.out.print(i+" "));
		long e1=System.currentTimeMillis();
		System.out.println("\nTime taken "+(e1-s1));
		
	}
}
