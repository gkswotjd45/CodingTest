package java_codingTest_연습;
import java.util.*;
public class Programmes_같은숫자는싫어 {


	static public class Solution {
	    public int[] solution(int []arr) {
	        Stack<Integer> stack = new Stack<Integer>();
	        
	        // peek() : 스택에서 top에 있는 데이터를 반환한다.
	        // pop() : 스택에서 맨 위에 이쓴 데이터를 꺼내온다.
	        for(int n : arr) {
	        	// 스택이 빈 경우와 스택의 맨위(이전 숫자)와 다른 경우 스택에 추가한다.
	        	if(stack.isEmpty() || stack.peek() != n) {
	        		stack.add(n);
	        	}
	        }
	        int [] answer = new int[stack.size()];
	        int index = 0;
	        for(int n : stack) {
	        	answer[index++] = n;
	        }
	        return answer;
	    }
	}
}
