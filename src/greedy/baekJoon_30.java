package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekJoon_30 {
	static StringBuilder sb;
	static int max = Integer.MIN_VALUE;
	static void thirty() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력한 숫자 (문자열)
		String num = br.readLine();

		// 입력 받은 문자열을 charter형 배열로 담기
		char [] charter = new char[num.length()];
		
		// 해당 정수 받을 공간 설정
		int sum = 0;
		
		for(int i =0; i<charter.length; i++) {
			charter[i] = num.charAt(i);
		};
		
		// 각 숫자가 담긴 배열을 오름차순으로 정렬
		Arrays.sort(charter);
		sb = new StringBuilder();
		for(int j = charter.length-1; j>=0; j--) {
			int a = charter[j] - '0';
			sum += a;
			sb.append(a);
		}
		
		// 마지막자리가 0이 아니거나, 3으로 나눌 수 없는 경우
		if(charter[0] != '0' || sum % 3 !=0) {
			sb = new StringBuilder();
			sb.append("-1");
		}
	}

	public static void main(String[] args) throws IOException {
		thirty();
		System.out.println(sb);
	}
}
