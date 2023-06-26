package java_codingTest_연습;

import java.util.logging.Logger;

public class CodingTest {
	public static void main(String[] args) {
		
		int answer = 0;
		
		int num1=3, num2 =2;

		double a = Double.parseDouble(Integer.toString(num1)) / num2;
		answer = (int) (a * 1000);
		Logger log;
		System.out.println(answer);
		
	}
}
