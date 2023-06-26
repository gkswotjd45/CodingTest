package java_codingTest_연습;

public class Programmes_멀리뛰기 {
	static class Solution {
		
		// 재귀함수 // 피보나치 함수
	    public long solution(int n) {
	    	
	    	int [] dp = new int[2001];
	    	
	    	dp[1] = 1;
	    	dp[2] = 2;
	    	
	    	for(int i = 3; i<2001; i++) {
	    		dp[i] = (dp[i-2] + dp[i-2]) % 1234567;
	    	}
	    	
	    	return dp[n];
	    }

	    
	    public static void main(String[] args) {
			Solution solution = new Solution();
			System.out.println(solution.solution(4));
		}
	}
}
