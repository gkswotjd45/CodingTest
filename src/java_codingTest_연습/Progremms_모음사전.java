package java_codingTest_연습;

import java.util.ArrayList;
import java.util.List;

public class Progremms_모음사전 {
	static class Soluation {
		private static final char[] CHARS = "AEIOU".toCharArray();

		// word로 시작하는 모든 단어를 List에 담음
		private List<String> generate(String word	) {
			List<String> words = new ArrayList<>();
			words.add(word);

			// word의 길이가 5일때 word를 반환 .
			if (word.length() == 5)
				return words;

			// 모든 문자를 word에 이어붙이는 방식
			for (char c : CHARS) {
				words.addAll(generate(word + c));

			}
			return words;
		}

		public int soluation(String word) {
		return generate("").indexOf(word);
		}

//		static String[] arr;
//		static List<String> list;
//
//		public int solution(String word) {
//
//			int answer = 0;
//
//			list = new ArrayList<>(); // 모음 글자를 다 담을 모든 리스트 함수
//			arr = new String[] { "A", "E", "I", "O", "U" };
//			// 완전탐색 메서드 호출
//			recursion(word, "", 0);
//
//			// 선형 탐색
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i).equals(word)) {
//					answer = i;
//					break;
//				}
//			}
//			return answer;
//		}
//
//		// 완전탐색 메서드
//		static void recursion(String word, String str, int depth) {
//			list.add(str);
//
//			if (depth == 5) {
//				return;
//			}
//
//			for (int i = 0; i < arr.length; i++) {
//				recursion(word, str + arr[i], depth + 1);
//			}
//		}
//	}
	}
}
