package com.lamda.example;

@FunctionalInterface

interface I1 {
		public void m1();
	}

class A1{	
	public void test() {System.out.println("reference A implementation of I interface");};
}

public class MyNonStaticRef {
		public static void main(String[] str){
		I1 obj = new A1()::test;		
		obj.m1();
	}

}
