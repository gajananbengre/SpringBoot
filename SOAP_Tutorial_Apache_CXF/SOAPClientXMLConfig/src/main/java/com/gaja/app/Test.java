package com.gaja.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		Test t = new Test();
		
		MathOperation addition = (int a , int b) -> a + b;
		MathOperation subtraction = (int a , int b) -> a - b;
		MathOperation multiply = (int a , int b) -> a * b;
		MathOperation divide = (int a , int b) -> a / b;
		
		System.out.println(t.operate(5, 10, addition));
    }
	
	interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   interface GreetingService {
	      void sayMessage(String message);
	   }
		
	   private int operate(int a, int b, MathOperation mathOperation) {
	      return mathOperation.operation(a, b);
	   }

}
