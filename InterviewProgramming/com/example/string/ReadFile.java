package com.example.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

	public static void ReadUsingBufferedReader() throws FileNotFoundException,IOException
	{
		String str;
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\AYUSH\\Desktop\\file.txt"));

		while((str=br.readLine())!=null)
			System.out.println(str);
		br.close();
	}
	public static void ReadUsingScanner() throws FileNotFoundException,IOException
	{
		File file=new File("C:\\Users\\AYUSH\\Desktop\\file.txt");
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine())
			System.out.println(sc.nextLine());
		sc.close();
	}

	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		//ReadUsingBufferedReader();
		ReadUsingScanner();

	}

}
