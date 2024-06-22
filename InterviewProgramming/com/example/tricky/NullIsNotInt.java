package com.example.tricky;

public class NullIsNotInt 
{
    int methodOfA()
    {
        return (true ? null : 0);
    }
    
    public static void main(String[] args)
    {
    	NullIsNotInt p=new NullIsNotInt();
    	System.out.println(p.methodOfA());
    }
}
