package com.lamda.example;
import java.util.Scanner;
import java.util.function.*;



public class UsingFuntionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

         Function <String , Integer> fn= (String s) ->{
        	 System.out.println("using fucntion "+ s);
         		return s.length();					
         		};
		System.out.println("please enter your name");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		System.out.println("out of this program is "+fn.apply(s1));
			
		
	}

}
