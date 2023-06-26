package java_codingTest_연습;

public class Programmes_이진변환반복하기 {
	static class Solution {
//		public int[] solution(String s) {
//			int[] answer = {};
//			String twobinary = "";
//			int zeroCount = 0;
//			int forcount = 0;
//			
//			while (!(twobinary.equals("1"))) {
//				for (char piece : s.toCharArray()) {
//					if(piece == 0) {
//						zeroCount++;
//					} else {
//						twobinary += piece;
//					}
//				}
//				forcount++;
//				s = null;
//				System.out.println(twobinary);
//				s = Integer.toString(Integer.parseInt(twobinary,2));
//			}
//			
//			answer[0] = forcount;
//			answer[1] = zeroCount;
//			return answer;
//		}
		
		// 문자열에 포함된 0 세기
		public int countZeros(String s) {
			int zeros = 0;
			for(char c : s.toCharArray()) {
				if(c=='0') zeros++;
			}
			return zeros;
		}
		
		public int[] solution(String s) {
			int loop = 0; // 반복횟수
			int removed = 0; // 제거 횟수
			
			//s가 "1"이 될 때까지 반복하며 loop, removed 누적
			
			while(!s.equals("1")) {
				int zeros = countZeros(s);
				loop += 1; // 반복문 1회 증가
				removed += zeros; // 삭제된 0의 개수를 저장
				
				//문자열 s 변환
				int ones = s.length() - zeros; // 현재 문자열 길이에 0의 개수값을 차감
				s = Integer.toString(ones,2);
			}
			
			return new int[] {loop,removed};
			
		}
		
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int reselt[] = solution.solution("110010101001");
		System.err.println(reselt);
	}
}
