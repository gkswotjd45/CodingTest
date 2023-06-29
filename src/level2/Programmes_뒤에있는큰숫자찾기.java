package level2;

import java.util.Stack;

public class Programmes_뒤에있는큰숫자찾기 {
	static class Solution {
	    public int[] solution(int[] numbers) {
	        int[] answer = new int [numbers.length];
	        
	        //  2. stack을 이용하는 방식
	        Stack<Integer> ans = new Stack<>();
	        
	        // 첫번쨰 number 인덱스 stack에 넣기
	        ans.push(0);
	        
	        // 이후 두 번째 원소부터 numbers 탐색
	        for(int i=1; i<numbers.length; i++) {
	        	while(!ans.empty() && numbers[ans.peek()] <numbers[i]) {
	        		// 뒤에 있는 큰 수에 해당하는 모든 값 pop
	        		answer[ans.pop()] = numbers[i];
	        	}
	        	
	        	// 현재 인덱스 push
	        	ans.push(i);
	        }
	        
	        while(!ans.isEmpty()) {
	        	answer[ans.pop()] = -1;
	        }
	        
	        //  1.이중 for문으로 푸는 방식.
//	        for(int i = 0; i<numbers.length; i++) {
//	        	if(i== numbers.length -1) {
//	        		answer[i] = -1;
//	        	}
//	        	for(int j = i+1; j<numbers.length; j++) {
//	        		if(numbers[i]<numbers[j]) {
//	        			answer[i] = numbers[j];
//	        			break;
//	        		}else if (numbers[i]>=numbers[j]) {
//	        			// 같거나 클 경우 계속 진행.
//	        			// 마지막에 도달할 경우
//	        			if(j == numbers.length -1) {
//	        				answer[i] = -1;
//	        			}
//	        		}
//	        		continue;
//	        	}
//	        }
//	        
	        for(int i = 0; i<answer.length; i++) {
	        	System.out.println(answer[i]);
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr = {2,3,3,5};
		System.out.println(solution.solution(arr));
	}
}
