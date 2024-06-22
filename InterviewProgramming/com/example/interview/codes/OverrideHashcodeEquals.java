package com.interview.codes;

class Kat{
	int id;
	String name;
	public Kat(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int hashcode()
	{
		final int prime=31;
		int result=1;
		result=prime*result+id;
		result=prime*result+name==null?0:name.hashCode();
		return result;
	}
	public boolean equals(Object obj)
	{
		if(obj==this)
			return true;
		if(obj==null || obj.getClass()!=this.getClass())
			return false;
		Kat k=(Kat)obj;
		return this.id==k.id && this.name==k.name;
	}
}
public class OverrideHashcodeEquals {

	public static void main(String[] args) {
		
		Kat k1=new Kat(3,"ayush");
		Kat k2=new Kat(3,"ayush");
		System.out.println(k1.hashcode()+" "+k2.hashcode());
		System.out.println(k1.equals(k2));

	}

}
