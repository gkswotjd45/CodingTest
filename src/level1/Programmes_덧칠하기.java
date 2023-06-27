package level1;
import java.util.Arrays;

public class Programmes_덧칠하기 {
	static class Solution {
		public int solution(int n, int m, int[] section) {
			int answer = 0;
			int currentPos = 0; // 롤러가 닿는 가장 마지막의 오른쪽 위치

			for (int target : section) {
				if (target > currentPos) {
					currentPos = target + m - 1; 
					// 현재 칠해야하는 벽의 위치 + 롤러가 닿는 최대 크기 -1
					answer++;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(solution.solution(4, 1, arr));

	}
}
