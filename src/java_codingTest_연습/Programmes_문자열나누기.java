package java_codingTest_연습;

import java.util.HashMap;

public class Programmes_문자열나누기 {
	static class Solution {
		public int solution(String s) {
			int answer = 0; // 결과
			char frist = s.charAt(0); // 첫번째 문자
			int different = 0; // 다른 문자 나온 빈도수
			int fristFrequency = 0; // 첫번째 문자가 나온 빈도수

			for (int i = 0; i < s.length(); i++) {
				// 첫번째 나온 글자의 빈도와 다른 문자의 나온 빈도가 동일할 경우
				if(fristFrequency == different) {
					answer++; // 결과를 증가.
					frist = s.charAt(i); // 다시 바뀐 문자열을 첫번째 글자로 매칭시킴.
				}
				// 맨처음 실행할때 수행. 
				if(s.charAt(i) == frist) fristFrequency++;
				else different++;
			
			}

			return answer;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("banana"));
	
	}
	
}
