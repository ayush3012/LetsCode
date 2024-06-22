package com.example.designpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ThroughSerialization implements Serializable{
	
	private static ThroughSerialization instance=new ThroughSerialization();
	private ThroughSerialization() {}
	
	public static ThroughSerialization getInstance()
	{
		return instance;
	}
	// If we do not implement readResolve we will get different instance in deserialization
	
	  protected Object readResolve() { return instance; }
	 
	String str;
	public void setString(String s)
	{
		this.str=s;
	}
	public String getString()
	{
		return this.str;
	}
}
public class ViolationSingletonThroughSerialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
             
		ThroughSerialization ins1=ThroughSerialization.getInstance();
		ins1.setString("ayush");
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\Users\\AYUSH\\eclipse-workspace"
				+ "\\InterviewProgramming\\FileForSerialization.txt"));
		out.writeObject(ins1);
		out.close();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\AYUSH\\eclipse-workspace"
				+ "\\InterviewProgramming\\FileForSerialization.txt"));
		
		ThroughSerialization ins2=(ThroughSerialization)in.readObject();
		in.close();
		System.out.println("ins1 "+ins1.hashCode()+" \nins2 "+ins2.hashCode());
		System.out.println("ins1 "+ins1.getString()+" \nins2 "+ins2.getString());
	}

}
