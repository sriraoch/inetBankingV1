package com.practice;

public class FIS {
	public static void main(String[] args) {
		
		Parent c = new Parent();
		c.m1();
	

	}
	 class Parent{
		
		void m1() {
			
			System.out.println("parent method");
		}
		
	}
	
 class Child extends Parent{
		
		void m1() {
			
			System.out.println("child method");
		}
		
	}

	
}


