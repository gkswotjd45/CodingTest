package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjun_스택 {
	static StringBuilder sb;

	public static void stack() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int commend = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		sb = new StringBuilder();
		for (int i = 0; i < commend; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (str.equals("pop")) {
				if (!stack.isEmpty()) {
					int num = stack.pop();
					sb.append(num).append("\n");
				} else
					sb.append("-1").append("\n");
			} else if (str.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (str.equals("top")) {
				if (!stack.isEmpty()) {
					int num = stack.peek();
					sb.append(num).append("\n");
				} else
					sb.append("-1").append("\n");

			} else if (str.equals("empty")) {
				if (!stack.isEmpty()) {
					sb.append("0").append("\n");
				} else
					sb.append("1").append("\n");
			}
		}

	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		stack();
		System.out.println(sb);
	}
}
