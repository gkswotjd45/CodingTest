package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjun_문자열 {
	static StringBuilder sb;
	static int T;
	public static void string() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		

		sb = new StringBuilder();
		
		for(int i =0; i<T; i++) {
			String str = br.readLine();
			String answer = String.valueOf(str.charAt(0));
			answer += str.charAt(str.length()-1);
			
			sb.append(answer+"\n");
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		string();
		System.out.println(sb);
	}
}
