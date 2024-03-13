package com.java8.lambda;

interface Interfa{

	public void add(int a , int b);

}

public class TestAaddWithParam {

	public static void main(String str[]) {

		Interfa intr = (a , b)-> System.out.print("Sum of a and B will be "+ (a+b));		
		intr.add(24, 2000);

	}


}
