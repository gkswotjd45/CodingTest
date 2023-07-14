package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjun_스택 {
	static int T; // 테스트 수
	static StringBuffer sb; // 결과 값

	public static void gwaulho() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine()); // 괄호의 수

		String guho;
		sb = new StringBuffer();
		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			st = new StringTokenizer(br.readLine()); //
			guho = st.nextToken();
			for (int j = 0; j < guho.length(); j++) {
				if (stack.isEmpty()) {
					stack.push(guho.charAt(j));
				}else if (stack.peek()== ')' && guho.charAt(j) == '(') {
					stack.push(guho.charAt(j));
				}else if ((stack.peek() != guho.charAt(j))) {
					stack.pop();
				}else {
					stack.push(guho.charAt(j));
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES" + "\n");
				
			} else {
				sb.append("NO" + "\n");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		gwaulho();
		System.out.println(sb);
	}
}
