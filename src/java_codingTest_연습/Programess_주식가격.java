package java_codingTest_연습;

import java.util.Stack;

public class Programess_주식가격 {
	static class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Integer> stack = new Stack<>(); // 빈 스택 객체
	        
	        // 시간에 따른 가격 변화의 배열 길이만큼 price의 값을 하나씩 확인
	        for(int i = 0; i<prices.length; i++) {
	        	
	        	// peek : 스택에 가장 위의 요소를 반환하는 함수
	        	// 스택이 비어 있지 않고, 주식가격이 떨어졌을 때  => 결과 배열에 값을 넣어주고, 해당 인덱스는 stack에서 pop하는 로직 구현
	        	while(!stack.isEmpty() && prices[i]<prices[stack.peek()]) {
	        		answer[stack.peek()] = i -stack.peek();
	        							 // 현재 주식이 감소 시점 - 주식이 처음 들어간 시점 
	        		stack.pop(); // 답을 구했기 때문에 stack에서 제거.
	        	}
	        	stack.push(i); // 주식이 감소하지 않았으면 스택에 해당 인덱스[시간]을 넣어둠.
	        }
	        // 주식
	        while(!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않는 주식
	        	answer[stack.peek()] = prices.length - stack.peek() - 1;
	        	//전체 길이에서 해당 인덱스를 빼주고, stack에서 pop하여 마무리
	        	stack.pop();
	        }
	       
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr = {1,2,3,2,3};
		solution.solution(arr);
	}
}
