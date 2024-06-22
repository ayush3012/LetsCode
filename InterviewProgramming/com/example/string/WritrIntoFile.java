package com.example.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritrIntoFile {

	public static void main(String[] args) throws IOException
	{
		
		BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\AYUSH\\Desktop\\file.txt"));
		bw.write("written from java code");
		System.out.println("successfully written ...check");
		bw.close();

	}

}
