package java_codingTest_연습;

import java.util.Stack;

public class Programmes_올바른괄호 {

	static class Solution {
//		// 소괄호로 된 문자열이 제대로 구성되어 있는 지 검사
//		boolean solution(String s) {
//			Stack<Character> stack = new Stack<>();
//			for(char c : s.toCharArray()) {
//				switch(c) {
//				// 문자 "("일 경우 안에 삽입
//				case '(' -> stack.push(c);
//				// 문자 ")"일 경우 안에 문자 "(" 제거
//				case ')' -> {
//					if (stack.isEmpty()) return false;
//					stack.pop();
//					}
//				}
//			}
//			// 비어 있다면 모든 값의 짝이 제대로 이루어짐, 그렇지 않으면 false에 해당.
//			return stack.empty();
//		}
		boolean solution(String s) {
			boolean answer = true;
			Stack<Character> stack = new Stack<Character>();

			if (s.charAt(0) == ')')
				return false;

			for (int i = 0; i < s.length(); i++) {
				if (!stack.isEmpty() && s.charAt(i) == ')') {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
			// 스택이 비어있으면 모든 괄호가 짝지어 졌으므로 true, 아닐경우 false
			answer = (stack.isEmpty()) ? true : false;
			return answer;

		}

		public static void main(String[] args) {
			Solution solution = new Solution();
			boolean result = solution.solution("(())");
			System.out.println(result);
		}
	}
}
