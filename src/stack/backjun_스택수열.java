package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Identity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjun_스택수열 {
	static StringBuilder sb;
	
	static void suyeol() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());

		Stack<Integer>stack = new Stack<>();
		
		int start = 0; // 초기값 
		sb = new StringBuilder();
		// 
		while(number-->0) {
			// 입력 받은 값
			int value = Integer.parseInt(br.readLine());
			
			if(value>start) {
				for(int i = start+1; i<=value; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				
				// 이전에 어디까지 입력 받았는지 알기 위한 값 저장.
				start = value;
			
			// 스택의 최상위의 있는 값이 입력받은 값과 일치하지 않은 경우
			}else if (stack.peek()!=value) {
				sb = new StringBuilder();
				sb.append("NO").append("\n");
				return;
			}
			
			// 입력받은 값이 스택의 최상위의 값과 동일하다면 stack에서 pop() 처리
			stack.pop();
			sb.append("-").append("\n");
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		suyeol();
		System.out.println(sb);
	}

}
