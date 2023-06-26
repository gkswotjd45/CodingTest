package java_codingTest_연습;



public class ProGrammes_행렬곱셈 {

	static class Solution {
		
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int[][] answer = {};
			int total[][] = new int[arr1.length][arr2[0].length];
			answer = total;
			for (int i = 0; i < total.length; i++) {
				for (int j = 0; j < total[0].length; j++) {
					for (int x = 0; x < arr2.length; x++) {
						total[i][j] += arr1[i][x] * arr2[x][j];
					}
				}
				
			}
			for (int i = 0; i < total.length; i++) {
				for (int j = 0; j < total[0].length; j++) {
					answer[i][j] = total[i][j]; 
				}	
			}
			return answer;
		}
	
	}
	
	public static void main(String[] args) {
		int arr1 [][] = { {1, 4}, {3, 2}, {4, 1}};
		int arr2 [][] = {{3, 3}, {3, 3}};
		Solution solution = new Solution();
		System.out.print(solution.solution(arr1, arr2));
	
		
		
	}
	
//	2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
//
//	제한 조건
//	행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
//	행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
//	곱할 수 있는 배열만 주어집니다.
}
