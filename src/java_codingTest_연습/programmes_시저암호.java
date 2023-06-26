package java_codingTest_연습;

public class programmes_시저암호 {

	static class Solution {

		// 문자열 밀어내기
		private char push(char c, int n) {
		// 알파벳 인 경우
		if ((c >= 'a' && c<='z') ) {
			c = (char)('a' + (((c+n) -'a') % 26));
		}
		else if((c>='A' && c<='Z')) {
			c = (char)('A' + (((c+n) -'A') % 26));
		}//알파벳이 아닌 경우 그대로 반환
			return c;
		}

		// 문자열 이어서붙여서 결과 나타내기
		public String solution(String s, int n) {
			StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				// 받은 문자열을 문자 단위로 하나씩 쪼개서 push 메서드에게로 전달
				sb.append(push(c,n));
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.solution("AB",5);
		System.out.println(result);
	}
}
