package java_codingTest_연습;

public class Programmes_가운데글자가져오기 {
	static class Solution {
		public String solution(String s) {
			String answer = "";
			int center = s.length() / 2;
			// 짝수 일때
			if (s.length() % 2 == 0) {
				for (int i = center - 1; i <= center; i++) {
					answer += s.charAt(i);
				}
			} else {
				// 홀수일때
				answer += s.charAt(center);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.solution("abcde");
		System.out.println(result);
	}
}
