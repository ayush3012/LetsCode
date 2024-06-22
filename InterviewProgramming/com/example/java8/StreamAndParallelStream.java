package com.example.java8;

import java.util.Arrays;
import java.util.List;

public class StreamAndParallelStream {

	public static void main(String[] args) {
		
		//single thread operate on stream and pipelined
		List<String> list = Arrays.asList( "Hello ", "G", "E", "E", "K", "S!");
		list.stream().forEach(System.out::print);
		
		System.out.println();
		//multiple thread operate on single stream
		list.parallelStream().forEach(System.out::print);//unordered o/p
		System.out.println();
		list.parallelStream().forEachOrdered(System.out::print); //ordered o/p

	}

}
