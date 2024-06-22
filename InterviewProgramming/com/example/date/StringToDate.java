package com.example.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

	public static void ConvertStringToDate(String str)
	{
		try {
		 Date d=new SimpleDateFormat("dd/mm/yyyy").parse(str);
		 System.out.println(d);
		}
		catch(ParseException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		
		String str="22/02/2023";
		
        ConvertStringToDate(str);
	}

}
