package com.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Stud{
	String name;
	int marks;
	public Stud(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
class SortStudents implements Comparator<Stu>
{
	public int compare(Stu s1,Stu s2)
	{
		return s1.name.compareTo(s2.name);
	}
}
public class SortUsingComparator {

	public static void main(String[] args) {
		List<Stu> Students=new ArrayList<>();
		Stu s1=new Stu("ayush",40);
		Stu s2=new Stu("meenakshi",50); 
		Stu s3=new Stu("jyoti",30);
		Stu s4=new Stu("tina",20); 
		Stu s5=new Stu("kareena",60);
		Students.add(s1);
		Students.add(s2);
		Students.add(s3);
		Students.add(s4);
		Students.add(s5);
		for(Stu a:Students)
			System.out.println(a);
		Collections.sort(Students,new SortStudents());
		System.out.println("---------comparator-------");
		for(Stu a:Students)
			System.out.println(a);
		
		System.out.println("================Another Method========");
		List<Stu> list=new ArrayList<>();
		Stu p1=new Stu("ayush",40);
		Stu p2=new Stu("meenakshi",50); 
		Stu p3=new Stu("jyoti",30);
		Stu p4=new Stu("ayush",20); 
		Stu p5=new Stu("kareena",60);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		Comparator<Stu> nameComp=(x1,y1)->x1.getName().compareTo(y1.getName());
		Comparator<Stu> marksComp=(x2,y2)->x2.getMarks()-y2.getMarks();
		
		Collections.sort(list, nameComp.thenComparing(marksComp));
		
		list.forEach(i->System.out.println(i));
	}

}
