package java_codingTest_연습;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class programmes_자연수뒤집어배열로만들기 {
	
	static class Solution {
		public int[] solution(long n) {
			String str = Long.toString(n); // long형 태로 받은 자연수를 String 형태로 변경
			String reversed = new StringBuilder(str).reverse().toString(); // String 형태로 받은 값을 뒤집어서 나타내기.
			char[] arr = reversed.toCharArray(); // 뒤집어서 나타낸 형태를 문자 단위로 나타내기 위해 char형 배열을 안에 넣기
			int [] result = new int[arr.length]; // 문자열을 다시 자연수로 변환
			
			for(int i = 0; i<result.length; i++) {
				result[i] = arr[i] - '0'; // char형 문자를 => int형 문자로 바꾸기 위해 변환.  ex) '1' = 아스키 코드 49, '0' 아스키 코드 48
			}
			
			return result;
		}
	}    
	
	
	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		
	    int[] result = solution.solution(12345);
	    
//	    System.out.println(Arrays.toString(result));
	    
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < result.length; i++) {
            bw.write(Integer.toString(result[i]));
        }
        bw.flush();
        bw.close();
		
	}
}
