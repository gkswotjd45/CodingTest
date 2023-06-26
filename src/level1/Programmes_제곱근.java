package level1;

public class Programmes_제곱근 {
	static class Solution {
	    public long solution(long n) {
	        long answer = 0;
	        
	        double num = Math.sqrt(n);
	        if(num % 1 == 0) {
	        	answer = (long) Math.pow(num+1, 2);
	        }else {
	        	answer = -1;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(121));
	}
}
