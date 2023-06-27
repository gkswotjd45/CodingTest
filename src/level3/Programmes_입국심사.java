package level3;

import java.util.Arrays;
import java.util.Stack;

public class Programmes_입국심사 {
	static class Solution {
		// 이분 탐색으로 수행.
		public long solution(int n, int[] times) {
			long answer = 0;
			Arrays.sort(times); // 소요시간 오름차순 정렬
			long left = 0;
			long right = times[times.length-1] * (long)n ; // 모든 사람이 가장 느리게 심사를 받을 경우 최대 소요시간

			// 탐색 조건 (left : 탐색을 시작하는 위치, right : 탐색을 종료하는 위치)
			while (left <= right) {
				long mid = (left + right) / 2;
	            long complete = 0;
	            for (int i = 0; i < times.length; i++)
	                complete += mid / times[i]; // 각 심시대 별 주어진 시간 (mid) 동안 몇 명의 사람을 심사할 수 있는 지 합산.
					if (complete < n) //심사한 사람 수가 총인원(n) 보다 작을 경우 // 해당 시간에는 모든 사람이 검사 받을 수 없음.
						left = mid + 1;
					else {
						right = mid - 1;
						answer = mid; // 모두 검사 받았으나, 더 최솟값이 있을 수 있음.
					}
				

			}

 			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr[] = { 7, 10 };
		System.out.println(solution.solution(6, arr));
	}
}
