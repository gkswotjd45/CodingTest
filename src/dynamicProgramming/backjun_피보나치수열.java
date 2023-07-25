package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.event.AncestorEvent;

public class backjun_피보나치수열 {
	static StringBuilder sb;
	static int T; // 테스트 케이스
	static Integer[][] dp;
	static void function() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		sb = new StringBuilder();
		for(int i=0; i<T ; i++) {
	
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			dp = new Integer[number+1][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			
			fibonacci(number);
			sb.append(dp[number][0]).append(" ").append(dp[number][1]).append("\n");
		}
	}

	public static Integer[] fibonacci(int number) {
		
		if(dp[number][0] == null && dp[number][1] == null) {
			dp[number][0] = fibonacci(number - 1)[0] + fibonacci(number - 2)[0];
			dp[number][1] = fibonacci(number - 1)[1] + fibonacci(number - 2)[1];
		}
		return dp[number];
	}

// 시간 초과나는 현상
//	public static int fibonacci(int number) {
//	
//	if(number == 0) {
//		answer[0] += 1; 
//		return 0;
//	}else if (number == 1) {
//		answer[1] += 1;
//		return 1;
//	}else {
//		return fibonacci(number-1) + fibonacci(number-2);
//	}
//}
	public static void main(String[] args) throws NumberFormatException, IOException {
		function();
		System.out.println(sb);
	}

}
