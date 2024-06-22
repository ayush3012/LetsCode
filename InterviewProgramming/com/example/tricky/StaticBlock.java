package com.example.tricky;

class A
{
    static void staticMethod()
    {
        System.out.println("Static Method");
    }
}
 
public class StaticBlock 
{
    public static void main(String[] args)
    {
        A a = null;
 
        a.staticMethod();
    }
}