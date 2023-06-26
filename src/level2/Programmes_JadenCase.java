package level2;

public class Programmes_JadenCase {
	static class Solution {
		public String solution(String s) {
			String answer = "";
			boolean blank = true; // 첫 글자도 대문자로 변환해야 하므로 초기값을 true로 설정
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ') {
					answer += " ";
					blank = true;
				} else if (blank) {
					// 공백 뒤에 오는 문자 또는 첫 문자를 대문자로 변환
					answer += Character.toUpperCase(s.charAt(i));
					blank = false;
				} else {
					// 그 외의 문자는 소문자로 변환
					answer += Character.toLowerCase(s.charAt(i));
				}
			}
			return answer;

//			String answer = "";
//			boolean blank = false;
//			for (int i = 0; i < s.length(); i++) {
//				// 먼저 첫글자가 소문자인지 확인한 후 대문자로 변환
//				if (i == 0) {
//					if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
//						answer += (char) (s.charAt(0) - 32) + "";
//						continue;
//					}
//				}
//				// 공백 다음 문자는 대문자로 변환.
//				if (s.charAt(i) == ' ') {
//					answer += " " + (char) (s.charAt(i + 1) - 32);
//					i++;
//					blank = true;
//				}
//				// 그외 문자인 경우 소문자.
//				else {
//				if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
//					answer += (char) (s.charAt(i) + 32);
//					i++;
//				}
//				answer += s.charAt(i) + "";
//				}
//			}
//			return answer;
//
//		}

		}
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		String s = solution.solution("3people unFollowed me");
		System.out.println(s);

	}
}
