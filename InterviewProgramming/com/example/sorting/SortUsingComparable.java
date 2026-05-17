package InterviewProgramming.com.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUsingComparable {

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
		Collections.sort(Students);
		System.out.println("----------------");
		for(Stu a:Students)
			System.out.println(a);
	}

}
