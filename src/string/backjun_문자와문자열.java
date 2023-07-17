package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjun_문자와문자열 {
	static StringBuilder sb; // 정답
	
	public static void  index() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int index = Integer.parseInt(br.readLine());
		
		char answer = str.charAt(index - 1);
		
		sb = new StringBuilder();
		sb.append(answer+"\n");
	}
	
	public static void main(String[] args) throws IOException {
		index();
		System.out.println(sb);
	}
}
