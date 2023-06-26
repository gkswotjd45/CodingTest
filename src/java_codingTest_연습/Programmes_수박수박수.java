package java_codingTest_연습;

public class Programmes_수박수박수 {
	static class Solution {
	    public String solution(int n) {
	        String answer = "";
	        char [] words = {'수','박'};
	        boolean check = false;
	        for(int i = 0; i<n; i++) {
	        	if(!check) {
	        	answer += words[0];
	        	check = true;
	        	}else {
	        		answer +=words[1];
	        		check=false;
	        	}
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.solution(3));

	}

}
