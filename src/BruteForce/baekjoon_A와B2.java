package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_A와B2 {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String find = br.readLine();
		boolean result;
		result = transform(str, find);

		sb = new StringBuilder();

		if (result == true) {
			sb.append("1");
		} else {
			sb.append("0");
		}
		System.out.println(sb);
	}

	private static boolean transform(String str, String find) {
		boolean flag = false;
		
		if(str.length() >= find.length()) {
			if(str.equals(find)) {
				return flag = true;
			}
			return flag =false;
		}
		
		if(find.charAt(find.length()-1) == 'A') {
			flag |= transform(str, find.substring(0,find.length()-1));
		}
		if(find.charAt(0) == 'B') {
			flag |= transform(str, 
					new StringBuilder().append(find).reverse().substring(0, find.length()-1).toString());
		}
		
		return flag;
	}
}
