package com.lamda.example;

@FunctionalInterface
interface I {
	
	public abstract void m1();
}

class A {	
	   	static public void test() {		   
		   System.out.println("I invoking M1() method");
	   }
}


public class MyReferencTesting {
	
	   public static void main(String[] Str) {		   
		   I i = A::test;		  
		   i.m1();		   
	   }
}
