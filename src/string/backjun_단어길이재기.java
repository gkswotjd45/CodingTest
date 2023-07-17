package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjun_단어길이재기 {
	static StringBuilder sb;
	
	public static void length() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int answer = str.length();
		
		sb = new StringBuilder();
		sb.append(answer + "\n");
		
		
	}
	
	public static void main(String[] args) throws Exception {
		length();
		System.out.println(sb);
	}

}
