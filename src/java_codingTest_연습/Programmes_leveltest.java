package java_codingTest_연습;

public class Programmes_leveltest {
	static class Solution {
	    public long[] solution(int x, int n) {
	        long[] answer = new long[n];
	        int b = x;
	        for(int a = 0; a<n; a++){
	            answer[a] = b;
	            b += x;
	            System.out.println(answer[a]);
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(-4, 2));
	}
}
