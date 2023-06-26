
package java_codingTest_연습;


public class Programmes_3진법뒤집기 {
	static class Solution {
//	    public long solution(int n)  {
//	        int answer = 0;
//	        answer = Integer.parseInt(Integer.toString(n,3)); // n을 3진법 정수변환
//	        // Integer.toString(숫자, 진법) => 숫자를 진법으로 변환 => 문자
//	        // Integer.parseInt(문자, 진법) => 문자를 진법으로 변환 => 숫자
//	        StringBuilder sb = new StringBuilder(Integer.toString(answer));
//	        return Long.parseLong(sb.reverse().toString(),3); // 3진법으로 변환된 정수를 다시 3진법으로 계산 => 10진법으로 나타냄.
//	    }
		public int solution(int n){
	        int answer = 0;
	        String str = "";
	        
	        while(n>0){
	            str += Integer.toString(n%3); // n을 3으로 나눈 나머지값을 str 문자열에 계속 추가함.
	            n /= 3;
	        }
	        answer = Integer.parseInt(str,3); // 3으로 나눈 나머지 값을 다시 3진법으로 곱하여 => 10진법으로 변환.
	            return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		long result = solution.solution(45);
		System.out.println(result);
	}
}
