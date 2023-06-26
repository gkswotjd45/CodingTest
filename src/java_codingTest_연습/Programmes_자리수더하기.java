package java_codingTest_연습;

public class Programmes_자리수더하기 {
	static public class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        String number = Integer.toString(n);
	        
	        for(int a : number.toCharArray()) {
	        	a -= 48; // 문자 a => 숫자 a 로 바꿔야 하므로 아스키 코드 48만큼 제외
	        	answer += a;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(123);
		System.out.println(result);

	}

}
