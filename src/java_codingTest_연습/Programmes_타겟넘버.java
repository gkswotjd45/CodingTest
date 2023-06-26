package java_codingTest_연습;

import java.util.Stack;

public class Programmes_타겟넘버 {
	static class Solution {
		int answer;
		int target ;
		int [] numbers;   
		
		void dfs(int index,int sum) {
			// index = 요번 수행할 인덱스에서 + or - 를 결정
			// sum = 여태까지 누적함
			
			// 탈출 조건
			if(index == numbers.length) {
				if(sum == target) {
				answer ++;
				}
				return ;
			}
			
			// 수행 동작
			dfs(index+1,sum + numbers[index]); // 다음 인덱스에, 여태까지 누적한 sum에 현재 숫자를 더한 형태 
			dfs(index+1,sum - numbers[index]); // 다음 인덱스에. 여태까지 누적한 sum에 현재 숫자를 뺀 형태
			
		}
		
		public int solution(int [] numbers, int targert) {
			answer = 0;
			this.numbers = numbers;
			this.target = targert;
			
			dfs(0,0);
			
			return answer;
					
		}
//		int answer = 0;
//		public void dfs(int[] numbers, int depth, int target, int sum) {
//	        //numbers : 알고리즘을 실행할 대상 배열
//			// depth : 노드의 깊이
//			// target: 타겟 넘버
//			// sum : 이전 노드까지의 결과 값
//			
//			// 마지막 노드까지 탐색했을 경우, dept와 number 배열의 길이가 같을 때 target과 sum을 비교호아
//			// 일치하면 answer 카운트 증가
//			
//			// 탐색할 노드가 남아 있는 경우 이전 노드까지의 합에서 현재 노드값을 더하고 빼는 두가지 경우로 깊이 우선 탐색 알고리즘 재실행
//			
//			if (depth == numbers.length) {
//				// 마지막 노드까지 탐색한 경우
//				if(target==sum) answer++;
//			}else {
//				// 탐색할 노드가 남아있는 경우
//				dfs(numbers,depth+1,target,sum+numbers[depth]); //해당 노드의 값을 더하고 다음 깊이 탐색
//				dfs(numbers,depth+1,target,sum-numbers[depth]); //해당 노드의 값을 빼고 다음 깊이 탑색,
//				
//			} 
//			
//	    }
//	    public int solution(int[] numbers, int target) {
//	       dfs(numbers, 0, target, 0);
//	        return answer;
//	    }
	    public static void main(String[] args) {
			Solution solution = new Solution();
			int result =solution.solution(new int [] {1,1,1,1,1},3);
			System.out.println(result);
		}
	}
}
