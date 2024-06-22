package com.example.designpattern;

//This is Structural design pattern. it modify the structure of program and used when we 
//want access control
interface DatabaseExecutor{
	public void executeQuery(String query) throws Exception;
}
class DatabaseExecutorImpl implements DatabaseExecutor{
	@Override
	public void executeQuery(String query) throws Exception
	{
		System.out.println("going to execute the query "+query);
	}
}
class DatabaseExecutorProxy implements DatabaseExecutor
{
	boolean isAdmin;
	DatabaseExecutor dbexe;
	DatabaseExecutorProxy(String user,String pwd)
	{
		if(user.equalsIgnoreCase("Admin") && pwd.equalsIgnoreCase("123"))
		{
			isAdmin=true;
			dbexe=new DatabaseExecutorImpl();
		}
	}
	@Override
	public void executeQuery(String query) throws Exception
	{
		if(isAdmin)
			dbexe.executeQuery(query);
		else
		{
			if(query.equalsIgnoreCase("delete"))
				throw new Exception("delete operation not allowed for this user");
			else
				dbexe.executeQuery(query);
		}
	}
}
public class ProxyDesignPattern {

	public static void main(String[] args) throws Exception{
		
		DatabaseExecutorProxy user1=new DatabaseExecutorProxy("admin","123");
		user1.executeQuery("delete");
		
		DatabaseExecutorProxy user2=new DatabaseExecutorProxy("Nonadmin","123");
		user2.executeQuery("delete");

	}

}
