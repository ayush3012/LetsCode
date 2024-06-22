package com.example.singleton;

public class SingletonDesignPattern {
	
	private static SingletonDesignPattern sdp=null;
	private SingletonDesignPattern() {}
	public static SingletonDesignPattern getInstance()
	{
		if(sdp==null)
			sdp=new SingletonDesignPattern();
		return sdp;
	}

	public static void main(String[] args) {
		
		SingletonDesignPattern s1=SingletonDesignPattern.getInstance();
		System.out.println(s1.toString());
		SingletonDesignPattern s2=SingletonDesignPattern.getInstance();
		System.out.println(s2.toString());
	}

}
