package level2;

import java.util.Stack;

public class Programmes_괄호회전하기_stack {
	static class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        
	        // 먼저 입력 s 값을 가지고
	        // s를 한칸씩 왼쪽으로 밀면서 새로운 문자열의 짝이 맞으면 answer += 1; 
	        // 주어진 sf를 가지고 왼쪽으로 i 칸씩 회전한 새로운 str을 만듬
	        
	        // 새로운 str 괄호 짝이 맞는지 판단하고 answer +=1;
	        // 닫히는 기호가 들어오면 stack.peek()으로 이전 기호가 열린기호인지 확인해서 pop 해주면되고
	        // stack이 비어있다면 그냥 push 해주면 됩니다. 스택이 비어있을 때 안해준다면, stack.peek()
	        // 부분에서 Exception이 발생할 수 있습니다.
	        
	        for (int i = 0; i < s.length(); i++) {
	            Stack<Character> stack = new Stack<>();
	            String str = s.substring(i, s.length()) + s.substring(0, i);
	            for (int j = 0; j < str.length(); j++) {
	                char c = str.charAt(j);
	                if (stack.isEmpty()) {
	                    stack.push(c);
	                } else if (c == ')' && stack.peek() == '(') {
	                    stack.pop();
	                } else if (c == '}' && stack.peek() == '{') {
	                    stack.pop();
	                } else if (c == ']' && stack.peek() == '[') {
	                    stack.pop();
	                } else {
	                    stack.push(c);
	                }
	            }
	            if (stack.isEmpty()) {
	                answer++;
	            }
	        }
	        
	        
	       return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution("[{()}]");
		System.out.println(result );
	}
}
