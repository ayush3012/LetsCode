package com.example.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		Function<Integer,Integer> f=i->i*i;
		/*
		 * @FunctionalInterface -----that have only one abstract method
		 * public interface Function<T, R>  
		 * { 
		 *    R apply(T t);   --i/o::anytype   return::anytype
		 * }
		 */
		System.out.println(f.apply(2));
		
		Predicate<Integer> p=i->i%2==0;
		/*
		 * @FunctionalInterface 
		 * public interface Predicate<T> 
		 * {
		 *    boolean test(T t);   --i/o::anytype   return::boolean
		 * }
		 */ 
         System.out.println(p.test(3));
         
         Consumer<Integer> c=a->{System.out.println("entered value is "+a);};
			/*
			 * @FunctionalInterface 
			 * public interface Consumer<T> 
			 * { 
			 *   void accept(T t);   --i/o::anytype   return::void
			 * }
			 */
         
         c.accept(5);
         
         Supplier<String> s=()->"Hi ayush";
         
			/*
			 * @FunctionalInterface 
			 * public interface Supplier<T> 
			 * {
			 * 
			 *     T get(); 
			 * }
			 */
         System.out.println(s.get());
	}

}
