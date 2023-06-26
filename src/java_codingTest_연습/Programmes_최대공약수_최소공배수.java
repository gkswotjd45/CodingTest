package java_codingTest_연습;

public class Programmes_최대공약수_최소공배수 {
	static class Solution {
	    public int[] solution(int n, int m) {
	        int[] answer  = new int[2];
	        int max = Math.max(n, m);
	        for(int i= 1; i<=max; i++) {
	        	if((n%i == 0) && (m%i == 0)) {
	        		answer[0] = i;
	        		int a = n / i;
	        		int b = m / i; 
	        		answer[1] = i * a * b;
	        	}
	        }
	        
	        if(answer.equals(null)) {
	        	answer[0] = 1;
        		answer[1] = n * m * 1;
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int result [] = solution.solution(2, 5);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
