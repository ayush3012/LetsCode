package com.example.AnnotationImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented  //to ensure that classes using your annotation show this in their generated JavaDoc
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
public @interface MyAnnotation {
	
	public abstract String name() default "ayush karna";
	
	public abstract String Dob() default "30-december-1992";

}



/* .java->.class-> machine code (source,class,runtime)
 * RetentionPolicy.SOURCE: remains in .java file only like devtools in spring boot which scan the 
 * java  file , Such annotations are used with build-tools that scan the file
 * 
 * Discard during the compile , Won't appear in the decompiled class
 * e.g @Override, @SuppressWarnings
 * 
 * 
 * RetentionPolicy.CLASS:this annotation is stored in the .class file & not available at the runtime
 * .Discard during class load.
 * 
 *  this is default , Appear in the decompiled class, but can't be inspected at run-time with
 *   reflection with getAnnotations()
 * 
 * 
 * RetentionPolicy.RUNTIME:Available at runtime.Do not discard , Appear in the decompiled class,
 *  and can be inspected at run-time with reflection with getAnnotations()
 * @Deprecated 
 * 
 * 
 */
