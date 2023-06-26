package java_codingTest_연습;

public class Programmes_콜라츠추측 {
	static class Solution {
		public int solution(int num) {
			int answer = 0;
			int count = 0; // 반복회수 저장
			// 500번까지 반복 하고 안되면 -1 리턴.
			for (int i = 0; i <= 500; i++) {
				if (num % 2 == 0) {
					num /= 2;
					count++;
				} else if (num % 3 == 0 || num != 1) {
					num = num * 3 + 1;
					count++;
				} else {
					break;
				}
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(5);
	}
	
}
