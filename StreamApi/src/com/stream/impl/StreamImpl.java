package com.stream.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stream.database.Worker;

public class StreamImpl {

	static List<Worker> al=new ArrayList<>();

	public static void updateList()
	{
		al.add(new Worker("ayush",20,10000,'M'));
		al.add(new Worker("karna",23,20000,'F'));
		al.add(new Worker("shakti",10,12000,'F'));
		al.add(new Worker("saurabh",30,1000,'M'));
		al.add(new Worker("prabhat",40,80000,'M'));
		al.add(new Worker("ranjan",12,40000,'M'));
		al.add(new Worker("nanhe",22,50000,'F'));
		al.add(new Worker("tannu",34,60000,'M'));
		al.add(new Worker("jishu",45,13000,'F'));
		al.add(new Worker("munna",8,19000,'M'));
		al.add(new Worker("bunty",11,16000,'M'));
		al.add(new Worker("bittu",5,70000,'F'));
	}

	public static void numberGender(String ef)
	{
		if(ef=="no") {
			long female=al.stream().filter(e->e.getGender()=='F').collect(Collectors.counting());
			long male=al.stream().filter(e->e.getGender()=='M').collect(Collectors.counting());
			System.out.println("female="+female+" male="+male);
		}
		else
		{
			Map<Character,Long> MaleFemale=al.stream()
					.collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
			MaleFemale.forEach((k,v)->System.out.println(k+" = "+v));
		}


	}

	public static void distinctGender()
	{
		al.stream().map(e->e.getGender()).distinct().forEach(e->System.out.println(e));
	}
	
	public static void avgAge()
	{
		al.stream().collect(Collectors
				.groupingBy(e->e.getGender(),Collectors
						.averagingInt(e->e.getAge()))).forEach((k,v)->System.out.println(k+" = "+v));
	}
	
	public static void highestPaid()
	{
		Optional<Worker> w=al.stream()
				.collect(Collectors.maxBy((e1,e2)->e1.getSalary()-e2.getSalary()));
		System.out.println(w.get());
	}

	public static void lowestPaid()
	{
		Optional<Worker> w=al.stream().collect(Collectors.minBy((e1,e2)->e1.getSalary()-e2.getSalary()));
		System.out.println(w.get());
	}
	
	public static void age20Above()
	{
		al.stream().filter(e->e.getAge()>20).forEach(e->System.out.println(e));
	}
	
	public static void detailsGender()
	{
		Map<Character,List<Worker>> dtls=al.stream()
				.collect(Collectors.groupingBy(e->e.getGender(),Collectors.toList()));
		dtls.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	public static void maxAgeGender()
	{
		Map<Character,Optional<Worker>>maxGen=al.stream()
		.collect(Collectors
				.groupingBy(e->e.getGender(),Collectors
						.maxBy((e1,e2)->e1.getAge()-e2.getAge())));
		maxGen.forEach((k,v)->System.out.println(k+" "+v));
	}
	public static void main(String[] args) {

		updateList();
		System.out.println("how many male and female worker::");
		numberGender("");
		System.out.println("\nDistinct genders are::");
        distinctGender();
        System.out.println("\nAverage age of male and female::");
        avgAge();
        System.out.println("\nHighest paid worker::");
        highestPaid();
        System.out.println("\nLowest paid worker::");
        lowestPaid();
        System.out.println("\nAge more than 20::");
        age20Above();
        System.out.println("\nDetails of all female and male::");
        detailsGender();
        System.out.println("\nMaximum age from female and male::");
        maxAgeGender();
        System.out.println("****Comparator implementation****");
        Comparator<Worker> nameSort=(w1,w2)->w1.getName().compareTo(w2.getName());
        Comparator<Worker> AgeSort=(w1,w2)->w1.getAge()-w2.getAge();
        al.stream().sorted(AgeSort.thenComparing(nameSort)).forEach(i->System.out.println(i));
        
	}

}
