package java_codingTest_연습;



public class Programmes_문자열내p와y의개수 {
	static class Solution {
		boolean solution(String s) {
	        boolean answer = true;
	        
	        s = s.toLowerCase(); // 모든 문자열 내의 값들을 소문자로 변경
	        
	        // p의 개수 세기
	        // 1. s의 전체문자열 길이 - s에 p값을 제외한 길이 = 'p'의 개수
	        int ps = s.length() - s.replace("p", "").length();
	 
	        // y의 개수 세기
	        // 2. s의 전체문자열 길이 - s에 y값을 제외한 길이 = 'y'의 개수
	        int ys = s.length() - s.replace("y", "").length();
	        
	        
	        return ps==ys;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean result = solution.solution("pPoooyY");
		System.out.println(result);
	}
}
