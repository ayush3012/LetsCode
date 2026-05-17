package InterviewProgramming.com.example.sorting;

public class Stu implements Comparable<Stu>{
	String name;
	int marks;
	public Stu(String name, int marks) {
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
	
	public String toString()
	{
		return "Student "+name+" marks "+marks;  
	}
	@Override
	public int compareTo(Stu s)
	{
		return this.marks-s.marks;
	}
}
