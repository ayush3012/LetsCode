package com.example.designpattern;

import java.sql.Driver;

class Firefox{
	public static Driver getDriver()
	{
		return null;
	}
	
	public static void generateHTMLreport(String test,Driver driver)
	{
		System.out.println("generating HTML for firefox");
	}
	public static void generateJUNITreport(String test,Driver driver)
	{
		System.out.println("generating JUNIT for firefox");
	}
}
class Chrome{
	public static Driver getDriver()
	{
		return null;
	}
	
	public static void generateHTMLreport(String test,Driver driver)
	{
		System.out.println("generating HTML for chrome");
	}
	public static void generateJUNITreport(String test,Driver driver)
	{
		System.out.println("generating JUNIT for chrome");
	}
}
class WebExplorerHelperFacade{
	
	public WebExplorerHelperFacade(String explorer,String report,String test)
	{
		Driver driver=null;
		switch(explorer)
		{
		case "firefox":
			driver=Firefox.getDriver();
			switch(report) 
			{
			case "html":
				Firefox.generateHTMLreport(test, driver);
			case "junt":
				Firefox.generateJUNITreport(test, driver);
			}
		break;
		case "chrome":
			driver=Chrome.getDriver();
			switch(report)
			{
			case "html":
				Chrome.generateHTMLreport(test, driver);
			case "junt":
				Chrome.generateJUNITreport(test, driver);
			}
		break;
		}
	}
}
public class FacadeDesignPattern {

	public static void main(String[] args) {
		
		String str="myTest";
		WebExplorerHelperFacade test1=new WebExplorerHelperFacade("firefox","html",str);
		WebExplorerHelperFacade test2=new WebExplorerHelperFacade("firefox","junit",str);
		WebExplorerHelperFacade test3=new WebExplorerHelperFacade("chrome","html",str);
		WebExplorerHelperFacade test4=new WebExplorerHelperFacade("chrome","junit",str);

	}

}
