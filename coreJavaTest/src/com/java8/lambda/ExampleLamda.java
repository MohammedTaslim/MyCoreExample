package com.java8.lambda;


interface interf {
	
	public void m(); 
}

public class ExampleLamda {
	
	
	public static void main(String[] args) {
			
		// TODO Auto-generated method stub
		
		//int sum= (int a, int b)-> (a+b);
		
		interf i = ()-> System.out.println("Hello Lambda");
		i.m();	
		
		interf i2 = ()-> {			
			int im = 20*20;			
			System.out.println("Hello Lambda"+ im);};
		i2.m();	
		 //s -> s.lenth();


		
	}
	
	
	

}
