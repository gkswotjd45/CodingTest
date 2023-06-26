package level2;

import java.util.HashSet;

// 완전 탐색_ 모든 경우의 숫자 조합을 구하여 => 소수 개수를 구함.
public class Programmes_소수찾기_dfs {
	static class Solution {
		static HashSet<Integer> set = new HashSet<>(); 
		static char [] numberChar; 
		static boolean[] visited;
		
	    public int solution(String numbers) {
	        int answer = 0;
	        visited = new boolean[numbers.length()];
	        numberChar = new char [numbers.length()];
	        // numbers = 011 일때 
	        // numberchar[] = [0, 1, 1]
	        for(int i= 0; i< numbers.length(); i++) {
	        	// char 문자를 => 숫자 int형으로 나타냄.
	        	numberChar[i] = numbers.charAt(i);
	        }
	        dfs("",0);
	        
	        answer = set.size();
	        return answer;
	    }

		private void dfs(String piece, int depth) {
			System.out.println("재귀 str:"+piece+", depth: "+depth);
			int num;
			// 조각에 값이 있을 경우 => 소수 판단.
			if(piece != "") {
				num = Integer.parseInt(piece);
				if(isPrime(num)) set.add(num); // 소수 판단
			}
			
			if(depth == numberChar.length) {
				return; // 뎁스가 끝까지 도달했을 때 다시 원래 위치로 되돌아가기
			}
			
			for(int i = 0; i<numberChar.length; i++) {
				if(visited[i]) continue; // true이면 넘어감 
				visited[i] = true;
				//System.out.println("for문 i:"+i+", str:"+piece);
				dfs(piece+numberChar[i], depth); // 방문했을 때, 재귀함수 수행
				//System.out.println("for문 i:"+i+", str:"+piece);
				visited[i] = false;
			}
		}
		
		// 소수 판단 
		public boolean isPrime(int num) {
			// 0과 1은 소수 X
			if(num < 2) {
				return false;
			}
			if (num == 2) {
				return true;
			}
			for(int i = 2 ; i<num; i++) {
				if(num % i == 0) {
					return false;
				}
			}
			
			return true;
			
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
////		solution.isPrime(17);
//		System.out.println(solution.isPrime(17));
		int result = solution.solution("17");
		System.out.println(result);
		
	}
}
