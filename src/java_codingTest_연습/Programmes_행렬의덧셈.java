package java_codingTest_연습;

public class Programmes_행렬의덧셈 {
	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int[][] answer = new int[arr1.length][arr1[0].length];
			
			for(int i = 0; i<arr1.length; i++) {
				for(int j = 0; j<arr1[0].length; j++) {
					answer[i][j] = arr1[i][j]+arr2[i][j];
				}
			}
			return answer;
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] arr1  = {{1,2},{2,3}};
		int [][] arr2 = {{3,4},{5,6}};
		int result [][] = solution.solution(arr1,arr2);
		
		for(int i = 0; i<arr1.length; i++) {
			for(int j = 0; j<arr1.length; j++) {
				System.out.println(result[i][j]);
			}
		}
		
	}
}
