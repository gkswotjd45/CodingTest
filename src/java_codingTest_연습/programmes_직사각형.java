package java_codingTest_연습;
import java.util.Scanner;

//class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        
//        for(int i = 0 ; i<b; i++) {
//        	for(int j = 0; j<a; j++) {
//        		System.out.println("*");
//        	}
//        }
//        System.out.println(a + b);
//    }
//}

public class programmes_직사각형 {
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    
	    for(int i = 0 ; i<b; i++) {
	    	for(int j = 0; j<a; j++) {
	    		System.out.print("*");
	    	}
	    	System.out.println();
	    }
	}
	
}
